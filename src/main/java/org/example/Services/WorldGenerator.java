package org.example.Services;

import org.example.Objects.Field;
import lombok.Getter;

import java.io.IOException;

public class WorldGenerator {
    @Getter
    private static final WorldGenerator instance = new WorldGenerator();
    private final FillAnimalsService fillAnimalsService = FillAnimalsService.getInstance();
    public void generateWorld(Field field) throws IOException {
        fillAnimalsService.fill(field);
    }
    private WorldGenerator(){}
}
