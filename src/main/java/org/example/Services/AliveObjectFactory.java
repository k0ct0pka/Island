package org.example.Services;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.example.Models.AliveObject;
import org.example.Models.Animal;
import org.example.Models.Plant;

import java.io.IOException;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AliveObjectFactory {
    @Getter
    static AliveObjectFactory instance;

    static {
        try {
            instance = new AliveObjectFactory();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    List<Animal> animals = ConfigReader.getInstance().readAnimalConfig();
    List<Plant> plants = ConfigReader.getInstance().readPlantConfig();

    private AliveObjectFactory() throws IOException {
    }

    public AliveObject create(AliveObject o) {
        if (o instanceof Animal a) {
            return animals.stream().filter(e -> e.getType() == ((Animal) o).getType()).findFirst().get();
        } else if (o instanceof Plant p) {
            return plants.stream().filter(e -> e.getType() == ((Plant) p).getType()).findFirst().get();
        }
        throw new RuntimeException();
    }
}
