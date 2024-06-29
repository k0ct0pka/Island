package org.example.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class Field {
    @JsonProperty
    private int WIDTH;

    @JsonProperty
    private int HEIGHT;

    @Setter
    private List<List<Cell>> cells = Collections.synchronizedList(new ArrayList<>());
    public Field(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

    }

}
