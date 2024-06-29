package org.example.Services;

import org.example.Models.Plant;
import org.example.Objects.Cell;
import org.example.Objects.Field;
import lombok.Getter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GrowService {
    @Getter
    private static GrowService instance;

    static {
        try {
            instance = new GrowService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private CountAliveObjectsInCellService countAliveObjectsInCellService = CountAliveObjectsInCellService.getInstance();
    private List<Plant> plants = ConfigReader.getInstance().readPlantConfig();

    private GrowService() throws IOException {

    }

    private AliveObjectFactory factory = AliveObjectFactory.getInstance();

    public void grow(Field field) {
        for (Plant plant : plants) {
            Cell cell = peekRndCell(field);
            if (countAliveObjectsInCellService.count(cell, plant) >= plant.getCapacityInOneCell()) return;
            cell.getAliveObjects().add(factory.create(plant));
        }
    }

    private Cell peekRndCell(Field field) {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        int x = rnd.nextInt(field.getWIDTH());
        int y = rnd.nextInt(field.getHEIGHT());
        return field.getCells().get(x).get(y);
    }
}
