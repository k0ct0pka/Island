package org.example.Utils;

import lombok.Getter;
import org.example.Services.ConfigReader;

public class GameParams {
    @Getter
    private static final ConfigReader reader = ConfigReader.getInstance();
    @Getter
    private int timeTaktMilis;
    private GameParams() {
    }
}
