package org.example.Services;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.example.Models.Animal;
import org.example.Objects.Cell;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReproduceService {
    @Getter
    static ReproduceService instance = new ReproduceService();
    CountAliveObjectsInCellService countAliveObjectsInCellService = CountAliveObjectsInCellService.getInstance();
    AliveObjectFactory factory = AliveObjectFactory.getInstance();

    private ReproduceService() {
    }

    public void reproduce(Cell cell, Animal animal) {
        if (countAliveObjectsInCellService.count(cell, animal) < 2 || countAliveObjectsInCellService.count(cell, animal) >= animal.getCapacityInOneCell())
            return;
        if (Math.random() * 100 > 50) return;
        for (int i = 0; i < animal.getCountKids(); i++) {
            cell.getAliveObjects().add(factory.create(animal));
        }
    }
}
