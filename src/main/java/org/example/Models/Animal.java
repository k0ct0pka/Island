package org.example.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class Animal extends AliveObject {
    @JsonProperty
    AnimalType type;
    @JsonProperty
    int countKids;
    @JsonProperty
    int age;
    @JsonProperty
    double maxWeight;
    @JsonProperty
    int speed;
    @JsonProperty
    double weightToBeFull;
    @JsonProperty
    double minWeight;

    public Animal(double weight, int count, AnimalType type, int countKids, int age, double maxWeight, int speed, double weightToBeFull, double minWeight) {
        super(weight, count);
        this.type = type;
        this.age = age;
        this.countKids = countKids;
        this.maxWeight = maxWeight;
        this.speed = speed;
        this.weightToBeFull = weightToBeFull;
        this.minWeight = minWeight;
    }

    @Override
    public boolean isPoisoned() {
        return type.isPoisoned();
    }
}
