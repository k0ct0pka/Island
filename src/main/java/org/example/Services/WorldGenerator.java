package org.example.Services;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.example.Objects.Field;

import java.io.IOException;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WorldGenerator {
    @Getter
    static WorldGenerator instance = new WorldGenerator();
    FillAnimalsService fillAnimalsService = FillAnimalsService.getInstance();

    private WorldGenerator() {
    }

    public void generateWorld(Field field) throws IOException {
        fillAnimalsService.fill(field);
    }
}
