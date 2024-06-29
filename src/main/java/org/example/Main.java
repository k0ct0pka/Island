package org.example;

import org.example.*;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.start();
//        List< AliveObject > objects = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            objects.add(new Plant(PlantType.GRASS));
//            objects.add(new Animal(AnimalType.DEER));
//        }
//        Cell cell = new Cell(objects, 0 ,0);
//        while(true){
//            try{
//                System.out.println(cell.getAliveObjects().size());
//                cell.newDay();
//                Thread.sleep(200);
//            } catch (Exception e){
//                e.printStackTrace();
//                System.out.println("dd");
//            }
//        }
//        ObjectMapper mapper = new ObjectMapper(new JsonFactory());
//        List<Animal> animal = mapper.readValue(new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\Island\\src\\Configs\\animals.json"), new TypeReference<List<Animal>>() {});
//        System.out.println(animal);
//        WorldGenerator worldGenerator = WorldGenerator.getInstance();
//        Field field = ConfigReader.getInstance().readMapConfig();
//        worldGenerator.generateWorld(field);
//        System.out.println(field.getCells().get(1).get(1).getAliveObjects().size());
    }
}