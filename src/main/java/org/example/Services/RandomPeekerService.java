package org.example.Services;

import lombok.Getter;
import org.example.Objects.Cell;
import org.example.Objects.Field;

import java.util.concurrent.ThreadLocalRandom;

public class RandomPeekerService {
    @Getter
    private static final RandomPeekerService instance = new RandomPeekerService();

    private RandomPeekerService() {
    }

    public Cell peekRndCell(Field field) {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        int x = rnd.nextInt(field.getWIDTH());
        int y = rnd.nextInt(field.getHEIGHT());
        return field.getCells().get(x).get(y);
    }
}
