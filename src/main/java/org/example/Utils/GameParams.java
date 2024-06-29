package org.example.Utils;

import org.example.Services.ConfigReader;
import lombok.Getter;

public class GameParams {
    @Getter
    private static ConfigReader reader = ConfigReader.getInstance();
    @Getter
    private int timeTaktMilis;
    private GameParams(){};
}
