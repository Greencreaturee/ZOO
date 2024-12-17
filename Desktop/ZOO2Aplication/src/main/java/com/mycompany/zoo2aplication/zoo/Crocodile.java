package com.mycompany.zoo2aplication.zoo;

public class Crocodile extends Reptile {
    private boolean livesInWater;

    public Crocodile(int id, String name, int age, String scaleType, boolean livesInWater) {
        super(id, name, age, scaleType);
        this.livesInWater = livesInWater;
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating fish.");
    }
}
