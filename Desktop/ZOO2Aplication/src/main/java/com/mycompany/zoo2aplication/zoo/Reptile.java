package com.mycompany.zoo2aplication.zoo;

public abstract class Reptile extends Animal implements SwimmingBehavior {
    private String scaleType;

    public Reptile(int id, String name, int age, String scaleType) {
        super(id, name, age, AnimalType.REPTILE);
        this.scaleType = scaleType;
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming.");
    }
}
