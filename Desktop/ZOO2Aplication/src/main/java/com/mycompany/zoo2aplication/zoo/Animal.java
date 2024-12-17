package com.mycompany.zoo2aplication.zoo;

public abstract class Animal {
    private int id;
    private String name;
    private int age;
    private AnimalType type;

    private static int totalAnimals = 0;

    public Animal(int id, String name, int age, AnimalType type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.type = type;

        totalAnimals++;
    }

    public void sleep() {
        System.out.println(getName() + " is sleeping.");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public AnimalType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Animal ID: " + id + ", Name: " + name + ", Age: " + age + ", Type: " + type;
    }

    public abstract void eat();

    public static int getTotalAnimalsCount() {
        return totalAnimals;
    }
}
