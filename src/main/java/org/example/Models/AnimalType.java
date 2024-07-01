package org.example.Models;

public enum AnimalType {
    WOLF(AnimalClass.HUNTER, false) {
        @Override
        public String toString() {
            return "\uD83D\uDC3A";
        }
    },
    BEAR(AnimalClass.HUNTER, false) {
        @Override
        public String toString() {
            return "\uD83D\uDC3B";
        }
    },
    FOX(AnimalClass.HUNTER, false) {
        @Override
        public String toString() {
            return "\uD83E\uDD8A";
        }
    },
    DEER(AnimalClass.HERBIVOROUS, false) {
        @Override
        public String toString() {
            return "\uD83E\uDD8C";
        }
    },
    FROG(AnimalClass.HERBIVOROUS, true) {
        @Override
        public String toString() {
            return "\uD83D\uDC38";
        }
    },
    BOA(AnimalClass.HUNTER, false) {
        @Override
        public String toString() {
            return "\uD83D\uDC0D";
        }
    },
    EAGLE(AnimalClass.HUNTER, false) {
        @Override
        public String toString() {
            return "\uD83E\uDD85";
        }
    },
    HORSE(AnimalClass.HERBIVOROUS, false) {
        @Override
        public String toString() {
            return "\uD83D\uDC0E";
        }
    },
    RABBIT(AnimalClass.HERBIVOROUS, false) {
        @Override
        public String toString() {
            return "\uD83D\uDC07";
        }
    },
    MOUSE(AnimalClass.HERBIVOROUS, false) {
        @Override
        public String toString() {
            return "\uD83D\uDC01";
        }
    },
    GOAT(AnimalClass.HERBIVOROUS, false) {
        @Override
        public String toString() {
            return "\uD83D\uDC10";
        }
    },
    SHEEP(AnimalClass.HERBIVOROUS, false) {
        @Override
        public String toString() {
            return "\uD83D\uDC11";
        }
    },
    BOAR(AnimalClass.HUNTER, false) {
        @Override
        public String toString() {
            return "\uD83D\uDC17";
        }
    },
    BUFFALO(AnimalClass.HERBIVOROUS, false) {
        @Override
        public String toString() {
            return "\uD83D\uDC03";
        }
    },
    DUCK(AnimalClass.HERBIVOROUS, false) {
        @Override
        public String toString() {
            return "\uD83E\uDD86";
        }
    },
    CATERPILLAR(AnimalClass.HERBIVOROUS, true) {
        @Override
        public String toString() {
            return "\uD83D\uDC1B";
        }
    };


    private final AnimalClass animalClass;
    private final boolean isPoisoned;

    AnimalType(AnimalClass animalClass, boolean isPoisoned) {
        this.animalClass = animalClass;
        this.isPoisoned = isPoisoned;
    }

    public abstract String toString();

    public AnimalClass getAnimalClass() {
        return animalClass;
    }

    public boolean isPoisoned() {

        return isPoisoned;
    }

    public enum AnimalClass {
        HUNTER,
        HERBIVOROUS
    }

}
