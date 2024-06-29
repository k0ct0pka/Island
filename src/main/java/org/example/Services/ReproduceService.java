package org.example.Services;

import org.example.Models.Animal;
import org.example.Objects.Cell;
import lombok.Getter;

public class ReproduceService {
    private CountAliveObjectsInCellService countAliveObjectsInCellService = CountAliveObjectsInCellService.getInstance();
    private AliveObjectFactory factory = AliveObjectFactory.getInstance();
    private ReproduceService(){}
    @Getter
    private static ReproduceService instance = new ReproduceService();

    public void reproduce(Cell cell, Animal animal) {
        if (countAliveObjectsInCellService.count(cell, animal) < 2 || countAliveObjectsInCellService.count(cell,animal) >=animal.getCapacityInOneCell()) return;
        if(Math.random()*100>50)return;
        for (int i = 0; i < animal.getCountKids(); i++) {
            cell.getAliveObjects().add(factory.create(animal));
        }
    }
}
