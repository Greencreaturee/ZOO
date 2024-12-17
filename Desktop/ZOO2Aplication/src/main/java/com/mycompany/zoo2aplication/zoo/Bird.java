package com.mycompany.zoo2aplication.zoo;

public abstract class Bird extends Animal {
    private boolean canFly;

    public Bird(int id, String name, int age, boolean canFly) {
        super(id, name, age, AnimalType.BIRD);
        this.canFly = canFly;
    }

    public abstract void fly();
}
