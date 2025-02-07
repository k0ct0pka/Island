package org.example.Services;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.example.Models.Animal;
import org.example.Models.Plant;
import org.example.Objects.Field;
import org.example.Utils.GameParams;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class ConfigReader {
    @Getter
    private final static ConfigReader instance = new ConfigReader();

    private static final String MAP_CONFIG_PATH = "C:\\Users\\Lenovo\\IdeaProjects\\IslandGame\\src\\main\\java\\org\\example\\Configs\\map.json";
    private static final String ANIMALS_CONFIG_PATH = "C:\\Users\\Lenovo\\IdeaProjects\\IslandGame\\src\\main\\java\\org\\example\\Configs\\animals.json";
    private static final String PLANTS_CONFIG_PATH = "C:\\Users\\Lenovo\\IdeaProjects\\IslandGame\\src\\main\\java\\org\\example\\Configs\\plants.json";
    private static final String GAME_CONFIG_PATH = "C:\\Users\\Lenovo\\IdeaProjects\\IslandGame\\src\\main\\java\\org\\example\\Configs\\game.json";
    ObjectMapper mapper = new ObjectMapper(new JsonFactory());

    private ConfigReader() {
    }

    public GameParams readGameParams() throws IOException {
        return mapper.readValue(new FileInputStream(GAME_CONFIG_PATH), GameParams.class);
    }

    public Field readMapConfig() throws IOException {
        return mapper.readValue(new FileInputStream(MAP_CONFIG_PATH), Field.class);
    }

    public List<Animal> readAnimalConfig() throws IOException {
        return mapper.readValue(new FileInputStream(ANIMALS_CONFIG_PATH), new TypeReference<List<Animal>>() {
        });
    }

    public List<Plant> readPlantConfig() throws IOException {
        return mapper.readValue(new FileInputStream(PLANTS_CONFIG_PATH), new TypeReference<List<Plant>>() {
        });
    }
}
