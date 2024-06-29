package org.example.Objects;

import org.example.Models.AliveObject;
import org.example.Models.Animal;
import org.example.Models.AnimalType;
import org.example.Models.Plant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@AllArgsConstructor

public class Cell {
    private List<AliveObject> aliveObjects;
    private int x;
    private int y;

    private int getCountOfThisType(AnimalType type){


        int count = 0;
        for(AliveObject o : aliveObjects){

                if(o instanceof Animal){
                    Animal animal = (Animal) o;
                    if(animal.getType() == type)count++;
                }


        }
        return count;
    }
    private AliveObject getRandomObject(){
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        return aliveObjects.get(rnd.nextInt(aliveObjects.size()-1));
    }
    public void newDay(){
//        Runnable r = new Runnable(){
//            @Override
//            public void run() {
//                for(AliveObject aliveObject : aliveObjects){
//                    checkOnDead(aliveObject);
//                    if(aliveObject instanceof Animal a){
//                        a.live(getRandomObject());
//                        a.reproduce(Cell.this,getCountOfThisType(a.getType()));
//
//                    } else{
//                        Plant p = (Plant) aliveObject;
//                        p.live();
//                        p.grow(Cell.this);
//                    }
//                }
//            }
//        };
//        try(ExecutorService service = Executors.newCachedThreadPool();){
//            service.submit(r);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        for(AliveObject aliveObject : aliveObjects){
//
//                    if(aliveObject instanceof Animal a){
//                        a.live(getRandomObject());
//                        a.reproduce(Cell.this,getCountOfThisType(a.getType()));
//
//                    } else{
//                        Plant p = (Plant) aliveObject;
//                        p.live();
//                        p.grow(Cell.this);
//                    }
//                }
//        checkOnDead();

    }

    @Override
    public String toString() {
        return "Cell{" +
                "aliveObjects=" +aliveObjects.toString() +
                '}';
    }

//    private void checkOnDead(){
//        aliveObjects.removeIf(AliveObject::isDead);
//    }
}
