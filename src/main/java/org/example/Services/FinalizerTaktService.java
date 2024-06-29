package org.example.Services;

import org.example.Models.Animal;
import org.example.Objects.Cell;

public class FinalizerTaktService {
    public void completeTakt(Cell cell , Animal animal){
        animal.setWeight(animal.getWeight() - animal.getWeight()/5);
        if(animal.getWeight()<animal.getMinWeight())cell.getAliveObjects().remove(animal);
    }
}
