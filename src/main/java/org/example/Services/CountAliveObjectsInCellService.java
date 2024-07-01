package org.example.Services;

import lombok.Getter;
import org.example.Models.AliveObject;
import org.example.Models.Animal;
import org.example.Models.Plant;
import org.example.Objects.Cell;

import java.util.List;

public class CountAliveObjectsInCellService {
    @Getter
    private final static CountAliveObjectsInCellService instance = new CountAliveObjectsInCellService();

    private CountAliveObjectsInCellService() {
    }

    public int count(Cell cell, AliveObject animal) {
        int count = 0;
        List<AliveObject> objects = List.copyOf(cell.getAliveObjects());
        for (AliveObject o : objects) {
            if ((animal instanceof Animal a) && (o instanceof Animal o2) && (a.getType() == o2.getType())) {
                count++;
            }
            if ((animal instanceof Plant p1) && (o instanceof Plant p2) && (p1.getType() == p2.getType())) {
                count++;
            }
        }
        return count;
    }
}
