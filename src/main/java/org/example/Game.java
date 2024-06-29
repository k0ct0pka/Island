package org.example;

import org.example.Models.AliveObject;
import org.example.Models.Animal;
import org.example.Models.Plant;
import org.example.Objects.Cell;
import org.example.Objects.Field;
import org.example.Services.*;
import org.example.Utils.GameParams;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.example.Services.WorldGenerator;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class Game{
    WorldGenerator worldGenerator = WorldGenerator.getInstance();
    ConfigReader configReader = ConfigReader.getInstance();
    GrowService growService = GrowService.getInstance();
    FeedService feedService = FeedService.getInstance();
    MovingService movingService = MovingService.getInstance();
    ReproduceService reproduceService = ReproduceService.getInstance();
    GameParams gameParams = GameParams.getReader().readGameParams();
    ViewService viewService = ViewService.getInstance();
    FinalizerTaktService finalizerTaktService = new FinalizerTaktService();

    public Game() throws IOException {
    }

    public void start() throws IOException {
        final boolean[] isPlaying = {true};
            Field field = configReader.readMapConfig();
        ExecutorService service = Executors.newCachedThreadPool();
            worldGenerator.generateWorld(field);
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(r -> {
            Thread t = new Thread(r);
            t.setDaemon(false);
            return t;
        });





            scheduledExecutorService.scheduleWithFixedDelay(() -> {
                growService.grow(field);
                if (viewService.printStatistic(field)) {
                    isPlaying[0] = false;
                }

            }, gameParams.getTimeTaktMilis(), gameParams.getTimeTaktMilis(), TimeUnit.MILLISECONDS);

//        field.getCells()
//                .stream()
//                .flatMap(Collection::stream)
//                .parallel()
//                .forEach(t->{
//            t.getAliveObjects()
//                    .stream()
//                    .filter( a -> a instanceof Animal)
//                    .map(e -> (Animal)e)
//                    .forEach(animal ->{
//                reproduceService.reproduce(t,animal);
//                movingService.move(field,t,animal);
//                finalizerTaktService.completeTakt(t,animal);
//                        feedService.feed(t,animal);
//            });
//        });
        while (isPlaying[0]) {
            for (int i = 0; i < field.getCells().size(); i++) {
                Runnable r = getRunnable(i, field);
                service.submit(r);

            }
            ;
        }

    }

    private Runnable getRunnable(int i, Field field) {
        int finalI = i;
        Runnable r =() -> {



            for (int j = 0; j< field.getCells().get(finalI).size(); j++) {

                for (int k = 0; k < field.getCells().get(finalI).get(j).getAliveObjects().size(); k++) {

                    if(k >= field.getCells().get(finalI).get(j).getAliveObjects().size())break;
                    AliveObject aliveObjects = field.getCells().get(finalI).get(j).getAliveObjects().get(k);
                    if (aliveObjects instanceof Animal a) {
                        if (feedService.feed(field.getCells().get(finalI).get(j), a)) continue;
                        reproduceService.reproduce(field.getCells().get(finalI).get(j), a);
                        movingService.move(field, field.getCells().get(finalI).get(j), a);
                        finalizerTaktService.completeTakt(field.getCells().get(finalI).get(j), a);
                    }
                }
            }
        };
        return r;
    }


}
