package org.example.Services;

import org.example.Models.AliveObject;
import org.example.Models.Animal;
import org.example.Models.Plant;

import java.io.IOException;
import java.util.List;

public class AliveObjectFactory{
    private List<Animal> animals = ConfigReader.getInstance().readAnimalConfig();
    private List<Plant> plants = ConfigReader.getInstance().readPlantConfig();
    private static AliveObjectFactory instance;

    static {
        try {
            instance = new AliveObjectFactory();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static AliveObjectFactory getInstance() {
        return instance;
    }
    private AliveObjectFactory() throws IOException {
    }

    public AliveObject create(AliveObject o){
        if(o instanceof Animal a){
            return animals.stream().filter(e->e.getType()==((Animal) o).getType()).findFirst().get();
        } else if(o instanceof Plant p){
            return plants.stream().filter(e->e.getType()==((Plant) p).getType()).findFirst().get();
        }
        throw new RuntimeException();
    }
}
