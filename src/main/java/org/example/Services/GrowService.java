package org.example.Services;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.example.Models.Plant;
import org.example.Objects.Cell;
import org.example.Objects.Field;

import java.io.IOException;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GrowService {
    @Getter
    static GrowService instance;

    static {
        try {
            instance = new GrowService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    RandomPeekerService randomPeekerService = RandomPeekerService.getInstance();
    CountAliveObjectsInCellService countAliveObjectsInCellService = CountAliveObjectsInCellService.getInstance();
    List<Plant> plants = ConfigReader.getInstance().readPlantConfig();
    AliveObjectFactory factory = AliveObjectFactory.getInstance();

    private GrowService() throws IOException {

    }

    public void grow(Field field) {
        for (Plant plant : plants) {
            Cell cell = randomPeekerService.peekRndCell(field);
            if (countAliveObjectsInCellService.count(cell, plant) >= plant.getCapacityInOneCell()) return;
            cell.getAliveObjects().add(factory.create(plant));
        }
    }
}
