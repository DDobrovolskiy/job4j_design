package ru.job4j.io.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class AnimalHouse {
    private String name;
    private Animal[] animals;

    public AnimalHouse(String name, Animal... animals) {
        this.name = name;
        this.animals = animals;
    }

    public Animal getFirst() {
        return animals[0];
    }

    @Override
    public String toString() {
        return "AnimalHouse{"
                + "name='" + name + '\''
                + ", animals=" + Arrays.toString(animals)
                + '}';
    }

    public static void main(String[] args) {
        final AnimalHouse house1 = new AnimalHouse("Home1", new Animal("Tom"), new Animal("Jerry"));
        System.out.println(house1);
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(house1));
        String modHouse = "{"
                + "\"name\":Home2,"
                + "\"animals\":"
                + "["
                + "{"
                + "\"name\":Bill"
                + "},"
                + "{"
                + "\"name\":Tom"
                + "}"
                + "]"
                + "}";
        final AnimalHouse house2 = gson.fromJson(modHouse, AnimalHouse.class);
        System.out.println(house2);
        System.out.println(house2.getFirst());
    }
}
