package org.example.Models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
public class Plant extends AliveObject {
    private PlantType type;
    public Plant(double weight , int count , PlantType type){
        super(weight,count);
        this.type = type;
    }

    @Override
    public boolean isPoisoned() {
        return type.isPoisoned();
    }
}
