package org.example.Services;

import org.example.Models.AliveObject;
import org.example.Models.Animal;
import org.example.Models.Plant;
import org.example.Objects.Cell;
import org.example.Objects.Field;
import lombok.Getter;

import java.io.IOException;
import java.util.List;

public class ViewService {
    @Getter
    private static ViewService instance;

    static {
        try {
            instance = new ViewService();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Animal> animals = ConfigReader.getInstance().readAnimalConfig();
    private List<Plant> plants = ConfigReader.getInstance().readPlantConfig();
    private ViewService() throws IOException {}

    private CountAliveObjectsInCellService counter = CountAliveObjectsInCellService.getInstance();
    public boolean printStatistic(Field field){
        int count = 0;
        boolean isAllDied = true;
        for(Animal animal : animals){
            for(List<Cell> cells : field.getCells()){
                for(Cell cell : cells){
                    count+=counter.count(cell,animal);
                }
            }
            if(count != 0)isAllDied=false;
            System.out.println(animal.getType().toString()+": "+count);
            count=0;
        }
        for(Plant plant : plants){
            for(List<Cell> cells : field.getCells()){
                for(Cell cell : cells){
                    count+=counter.count(cell,plant);
                }
            }
            if(count != 0)isAllDied=false;
            System.out.println(plant.getType().toString()+": "+count);
            count=0;
        }
        return isAllDied;
    }
}
