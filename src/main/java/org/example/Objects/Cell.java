package org.example.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.Models.AliveObject;

import java.util.List;

@Getter
@AllArgsConstructor

public class Cell {
    private List<AliveObject> aliveObjects;
    private int x;
    private int y;

    @Override
    public String toString() {
        return "Cell{" +
                "aliveObjects=" + aliveObjects.toString() +
                '}';
    }

}
