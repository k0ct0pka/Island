package org.example.Services;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.example.Models.AnimalType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EatChanceService {
    @Getter
    static EatChanceService instance = new EatChanceService();
    @Getter
    HashMap<AnimalType, HashMap<AnimalType, Integer>> config = new HashMap<>();


    private EatChanceService() {
    }

    public int getProbability(AnimalType predator, AnimalType victim) {
        if (config.isEmpty()) readFile();
        return config.get(predator).get(victim);
    }

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Lenovo\\IdeaProjects\\IslandGame\\src\\main\\java\\org\\example\\Configs\\eatConfig.yml"))) {
            br.readLine();
            while (br.ready()) {
                AnimalType type = AnimalType.valueOf(br.readLine().trim().replaceAll(":", ""));
                HashMap<AnimalType, Integer> internalConfig = new HashMap<>();
                for (int i = 0; i < 17; i++) {
                    String text = br.readLine();
                    internalConfig.put(AnimalType.valueOf(text.trim().split(" ")[0].replaceAll(":", "")), Integer.valueOf(text.trim().split(" ")[1]));
                }
                config.put(type, internalConfig);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}