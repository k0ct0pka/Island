package org.example.Services;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.example.Models.Animal;
import org.example.Models.Plant;
import org.example.Objects.Cell;
import org.example.Objects.Field;

import java.io.IOException;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ViewService {
    @Getter
    static ViewService instance;

    static {
        try {
            instance = new ViewService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    List<Animal> animals = ConfigReader.getInstance().readAnimalConfig();
    List<Plant> plants = ConfigReader.getInstance().readPlantConfig();
    CountAliveObjectsInCellService counter = CountAliveObjectsInCellService.getInstance();

    private ViewService() throws IOException {
    }

    public boolean printStatistic(Field field) {
        int count = 0;
        boolean isAllDied = true;
        for (Animal animal : animals) {
            for (List<Cell> cells : field.getCells()) {
                for (Cell cell : cells) {
                    count += counter.count(cell, animal);
                }
            }
            if (count != 0) isAllDied = false;
            System.out.println(animal.getType().toString() + ": " + count);
            count = 0;
        }
        for (Plant plant : plants) {
            for (List<Cell> cells : field.getCells()) {
                for (Cell cell : cells) {
                    count += counter.count(cell, plant);
                }
            }
            if (count != 0) isAllDied = false;
            System.out.println(plant.getType().toString() + ": " + count);
            count = 0;
        }
        return isAllDied;
    }
}
