package org.example.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.example.Services.ConfigReader;

public class GameParams {
    @Getter
    private static final ConfigReader reader = ConfigReader.getInstance();
    @Getter
    @JsonProperty
    private int timeTaktMilis;
    private GameParams() {
    }
}
