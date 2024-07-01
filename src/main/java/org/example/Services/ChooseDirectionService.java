package org.example.Services;

import lombok.Getter;
import org.example.Models.Animal;
import org.example.Objects.Cell;
import org.example.Objects.Field;
import org.example.Utils.Direction;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ChooseDirectionService {
    @Getter
    private final static ChooseDirectionService instance = new ChooseDirectionService();

    private ChooseDirectionService() {
    }

    public Direction chooseDirection(Field field, Cell cell, Animal animal) {
        int speed = animal.getSpeed();
        List<Direction> directions = new java.util.ArrayList<>(Arrays.stream(Direction.values()).toList());
        if (cell.getX() - speed < 0) directions.remove(Direction.LEFT);
        if (cell.getX() + speed >= field.getWIDTH()) directions.remove(Direction.RIGHT);
        if (cell.getY() - speed < 0) directions.remove(Direction.TOP);
        if (cell.getY() + speed >= field.getHEIGHT()) directions.remove(Direction.DOWN);
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        return directions.get(rnd.nextInt(directions.size()));
    }
}
