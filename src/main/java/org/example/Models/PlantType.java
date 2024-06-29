package org.example.Models;

public enum PlantType {
    GRASS(false),
    TREE(false),
    MUSHROOMS(true)
    ;
    private final boolean isPoisoned;

    PlantType(boolean isPoisoned) {
        this.isPoisoned = isPoisoned;
    }

    public boolean isPoisoned() {

        return isPoisoned;
    }
}
