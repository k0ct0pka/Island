package org.example.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

}
