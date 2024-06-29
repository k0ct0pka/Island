package org.example.Services;

import org.example.Models.AliveObject;
import org.example.Models.Animal;
import org.example.Models.Plant;
import org.example.Objects.Cell;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountAliveObjectsInCellService {
    @Getter
    private static CountAliveObjectsInCellService instance = new CountAliveObjectsInCellService();
    private CountAliveObjectsInCellService(){}
    public int count(Cell cell , AliveObject animal){
        int count = 0;
        List<AliveObject> objects= List.copyOf(cell.getAliveObjects());
        for(AliveObject o : objects){
            if(animal instanceof Animal a){
                if(o instanceof Animal o2){
                    if(a.getType() == o2.getType())count++;
                }
            }
            if(animal instanceof Plant p1){
                if(o instanceof Plant p2)
                    if(p1.getType()==p2.getType())count++;
            }
        }
        return count;
    }
}
