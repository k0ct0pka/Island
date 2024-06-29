package org.example.Services;


import lombok.Getter;
import org.example.Models.AnimalType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class EatChanceService {
    @Getter
    private static EatChanceService instance = new EatChanceService();
    @Getter
    private HashMap<AnimalType, HashMap<AnimalType, Integer>> config = new HashMap<>();



    public int getProbability(AnimalType predator, AnimalType victim) {
        if (config.isEmpty()) readFile();
        return config.get(predator).get(victim);
    }

    private EatChanceService() {
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