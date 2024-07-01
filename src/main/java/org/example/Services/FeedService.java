package org.example.Services;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.example.Models.AliveObject;
import org.example.Models.Animal;
import org.example.Models.AnimalType;
import org.example.Models.Plant;
import org.example.Objects.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FeedService {
    @Getter
    static FeedService instance = new FeedService();
    EatChanceService eatChanceService = EatChanceService.getInstance();

    private FeedService() {

    }

    private boolean extracted(Cell cell, Animal animal, AliveObject objToEat, List<AliveObject> objectsToRemove) {
        if (objToEat.isPoisoned()) {
            objectsToRemove.add(animal);
            cell.getAliveObjects().removeAll(objectsToRemove);
            return true;
        }
        return false;
    }

    public boolean feed(Cell cell, Animal animal) {
        AliveObject objToEat = getRandomAnimal(cell);
        List<AliveObject> objectsToRemove = new ArrayList<>();
        boolean isFull = animal.getWeight() + objToEat.getWeight() < animal.getMaxWeight();
        if (objToEat instanceof Plant) {
            if (animal.getType().getAnimalClass() == AnimalType.AnimalClass.HUNTER) return false;
            if (isFull) {
                animal.setWeight(objToEat.getWeight() > animal.getWeightToBeFull() ? animal.getWeight() + animal.getWeightToBeFull() : animal.getWeight() + objToEat.getWeight());
                if (extracted(cell, animal, objToEat, objectsToRemove)) return true;
                objectsToRemove.add(objToEat);
            }
        } else if ((objToEat instanceof Animal) &&
                (Math.random() * 100 > eatChanceService.getProbability(animal.getType(), ((Animal) objToEat).getType())) &&
                isFull) {
            animal.setWeight(objToEat.getWeight() > animal.getWeightToBeFull() ? animal.getWeight() + animal.getWeightToBeFull() : animal.getWeight() + objToEat.getWeight());
            if (extracted(cell, animal, objToEat, objectsToRemove)) return true;
            objectsToRemove.add(objToEat);
        }
        cell.getAliveObjects().removeAll(objectsToRemove);
        return false;

    }

    private AliveObject getRandomAnimal(Cell cell) {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        return cell.getAliveObjects().get(rnd.nextInt(cell.getAliveObjects().size() - 1));
    }
}
