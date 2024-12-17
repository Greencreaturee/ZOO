package com.mycompany.zoo2aplication.zoo;

public class Eagle extends Bird {
    private double wingSpan;

    public Eagle(int id, String name, int age, boolean canFly, double wingSpan) {
        super(id, name, age, canFly);
        this.wingSpan = wingSpan;
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is hunting fish.");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is soaring high.");
    }
}
