package org.example.Services;

import org.example.Models.AliveObject;
import org.example.Models.Animal;
import org.example.Models.Plant;
import org.example.Objects.Cell;
import org.example.Objects.Field;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class FillAnimalsService {
    private static final FillAnimalsService instance = new FillAnimalsService();
    private final ConfigReader reader = ConfigReader.getInstance();
    public static FillAnimalsService getInstance(){
        return instance;
    }
    public void fill(Field field) throws IOException {
        List<Animal> objects = reader.readAnimalConfig();
        List<Plant> plants = reader.readPlantConfig();
        for (int i = 0; i < field.getWIDTH(); i++) {
            field.getCells().add(Collections.synchronizedList(new ArrayList<Cell>()));
            for (int j = 0; j < field.getHEIGHT(); j++) {
                field.getCells().get(i).add(null);
            }
        }
        for (int i = 0; i < field.getWIDTH(); i++) {
            for (int j = 0; j < field.getHEIGHT(); j++) {
                ThreadLocalRandom rnd = ThreadLocalRandom.current();
                List<AliveObject> aliveObjects = Collections.synchronizedList(new ArrayList<AliveObject>());
                for(AliveObject object : objects){
                    int countToAdd = rnd.nextInt(1,5);
                    for (int k = 0; k < countToAdd; k++) {
                        aliveObjects.add(object);
                        aliveObjects.add(plants.get(rnd.nextInt(3)));
                    }
                }
                field.getCells().get(i).set(j,new Cell(aliveObjects,i,j));
            }
        }
        Collections.shuffle(field.getCells());
    }
    private FillAnimalsService() {
    }
}
