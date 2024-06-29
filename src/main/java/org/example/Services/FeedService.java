package org.example.Services;

import org.example.Models.AliveObject;
import org.example.Models.Animal;
import org.example.Models.AnimalType;
import org.example.Models.Plant;
import org.example.Objects.Cell;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FeedService {
    @Getter
    private static FeedService instance = new FeedService();
    private FeedService(){

    }
    public boolean feed(Cell cell, Animal animal){
        AliveObject objToEat = getRandomAnimal(cell);
        List<AliveObject> objectsToRemove = new ArrayList<>();
        if(objToEat instanceof Plant){
            if(animal.getType().getAnimalClass()== AnimalType.AnimalClass.HUNTER)return false;
            if(animal.getWeight()+objToEat.getWeight()<animal.getMaxWeight()){
                animal.setWeight(objToEat.getWeight()>animal.getWeightToBeFull()? animal.getWeight() + animal.getWeightToBeFull():animal.getWeight()+objToEat.getWeight() );
                if(objToEat.isPoisoned()){
                    objectsToRemove.add((AliveObject)animal);
                    cell.getAliveObjects().removeAll(objectsToRemove);
                    return true;
                }
                objectsToRemove.add(objToEat);
            }
        } else if(objToEat instanceof Animal){
            if(animal.getType().getAnimalClass()== AnimalType.AnimalClass.HERBIVOROUS)return false ;
            if(animal.getWeight()+objToEat.getWeight()<animal.getMaxWeight()){
                animal.setWeight(objToEat.getWeight()>animal.getWeightToBeFull()? animal.getWeight() + animal.getWeightToBeFull():animal.getWeight()+objToEat.getWeight() );
                if(objToEat.isPoisoned()){
                    objectsToRemove.add((AliveObject)animal);
                    cell.getAliveObjects().removeAll(objectsToRemove);
                    return true;
                }
                objectsToRemove.add(objToEat);
            }
        }
        cell.getAliveObjects().removeAll(objectsToRemove);
        return false;

    }
    private AliveObject getRandomAnimal(Cell cell){
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        return cell.getAliveObjects().get(rnd.nextInt(cell.getAliveObjects().size()-1));
    }
}
