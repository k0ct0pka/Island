package org.example.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class AliveObject {
    @JsonProperty
    double weight;

    @JsonProperty
    int capacityInOneCell;

    public abstract boolean isPoisoned();
}
