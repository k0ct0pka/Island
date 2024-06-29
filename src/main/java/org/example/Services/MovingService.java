package org.example.Services;

import org.example.Models.AliveObject;
import org.example.Models.Animal;
import org.example.Objects.Cell;
import org.example.Objects.Field;
import org.example.Utils.Direction;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class MovingService {
    private ChooseDirectionService chooseDirectionService = ChooseDirectionService.getInstance();
    private CountAliveObjectsInCellService countAnimalInCellService = CountAliveObjectsInCellService.getInstance();
    @Getter
    private static MovingService instance = new MovingService();

    private MovingService(){}

    public void move(Field field, Cell cell, Animal animal) {
        Direction direction = chooseDirectionService.chooseDirection(field, cell, animal);
        int speed = animal.getSpeed();
        List<AliveObject> aliveObjectsToRemove = new ArrayList<>();
        switch (direction) {
            case RIGHT -> {
                if (countAnimalInCellService.count(field.getCells().get(cell.getX() + speed).get(cell.getY()), animal) >= animal.getCapacityInOneCell())
                    move(field, field.getCells().get(cell.getX() + speed).get(cell.getY()), animal);
                else {
                    aliveObjectsToRemove.add(animal);
                    field.getCells().get(cell.getX() + speed).get(cell.getY()).getAliveObjects().add(animal);
                    field.getCells().get(cell.getX()).get(cell.getY()).getAliveObjects().removeAll(aliveObjectsToRemove);
                }
            }
            case LEFT -> {
                if (countAnimalInCellService.count(field.getCells().get(cell.getX() - speed).get(cell.getY()), animal) >= animal.getCapacityInOneCell())
                    move(field, field.getCells().get(cell.getX() - speed).get(cell.getY()), animal);
                else {
                    aliveObjectsToRemove.add(animal);
                    field.getCells().get(cell.getX() - speed).get(cell.getY()).getAliveObjects().add(animal);
                    field.getCells().get(cell.getX()).get(cell.getY()).getAliveObjects().removeAll(aliveObjectsToRemove);
                }
            }
            case DOWN -> {
                if (countAnimalInCellService.count(field.getCells().get(cell.getX()).get(cell.getY() + speed), animal) >= animal.getCapacityInOneCell())
                    move(field, field.getCells().get(cell.getX()).get(cell.getY() + speed), animal);
                else {
                    aliveObjectsToRemove.add(animal);
                    field.getCells().get(cell.getX()).get(cell.getY() + speed).getAliveObjects().add(animal);
                    field.getCells().get(cell.getX()).get(cell.getY()).getAliveObjects().removeAll(aliveObjectsToRemove);
                }
            }
            case TOP -> {
                if (countAnimalInCellService.count(field.getCells().get(cell.getX()).get(cell.getY() - speed), animal) >= animal.getCapacityInOneCell())
                    move(field, field.getCells().get(cell.getX()).get(cell.getY() - speed), animal);
                else {
                    aliveObjectsToRemove.add(animal);
                    field.getCells().get(cell.getX()).get(cell.getY() - speed).getAliveObjects().add(animal);
                    field.getCells().get(cell.getX()).get(cell.getY()).getAliveObjects().removeAll(aliveObjectsToRemove);
                }
            }
            case null -> throw new NullPointerException("Incorrect Field Values");
        }
    }
}
