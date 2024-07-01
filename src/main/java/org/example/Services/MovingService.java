package org.example.Services;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.example.Models.AliveObject;
import org.example.Models.Animal;
import org.example.Objects.Cell;
import org.example.Objects.Field;
import org.example.Utils.Direction;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MovingService {
    @Getter
    static MovingService instance = new MovingService();
    ChooseDirectionService chooseDirectionService = ChooseDirectionService.getInstance();
    CountAliveObjectsInCellService countAnimalInCellService = CountAliveObjectsInCellService.getInstance();

    private MovingService() {
    }

    public void move(Field field, Cell cell, Animal animal) {
        Direction direction = chooseDirectionService.chooseDirection(field, cell, animal);
        int speed = animal.getSpeed();
        int x = cell.getX();
        int y = cell.getY();
        List<AliveObject> aliveObjectsToRemove = new ArrayList<>();
        switch (direction) {
            case RIGHT -> {
                if (countAnimalInCellService.count(field.getCells().get(x + speed).get(y), animal) >= animal.getCapacityInOneCell())
                    move(field, field.getCells().get(x + speed).get(y), animal);
                else {
                    aliveObjectsToRemove.add(animal);
                    field.getCells().get(x + speed).get(y).getAliveObjects().add(animal);
                    field.getCells().get(x).get(y).getAliveObjects().removeAll(aliveObjectsToRemove);
                }
            }
            case LEFT -> {
                if (countAnimalInCellService.count(field.getCells().get(x - speed).get(y), animal) >= animal.getCapacityInOneCell())
                    move(field, field.getCells().get(x - speed).get(y), animal);
                else {
                    aliveObjectsToRemove.add(animal);
                    field.getCells().get(x - speed).get(y).getAliveObjects().add(animal);
                    field.getCells().get(x).get(y).getAliveObjects().removeAll(aliveObjectsToRemove);
                }
            }
            case DOWN -> {
                if (countAnimalInCellService.count(field.getCells().get(x).get(y + speed), animal) >= animal.getCapacityInOneCell())
                    move(field, field.getCells().get(x).get(y + speed), animal);
                else {
                    aliveObjectsToRemove.add(animal);
                    field.getCells().get(x).get(y + speed).getAliveObjects().add(animal);
                    field.getCells().get(x).get(y).getAliveObjects().removeAll(aliveObjectsToRemove);
                }
            }
            case TOP -> {
                if (countAnimalInCellService.count(field.getCells().get(x).get(y - speed), animal) >= animal.getCapacityInOneCell())
                    move(field, field.getCells().get(x).get(y - speed), animal);
                else {
                    aliveObjectsToRemove.add(animal);
                    field.getCells().get(x).get(y - speed).getAliveObjects().add(animal);
                    field.getCells().get(x).get(y).getAliveObjects().removeAll(aliveObjectsToRemove);
                }
            }
            case null -> throw new NullPointerException("Incorrect Field Values");
        }
    }
}
