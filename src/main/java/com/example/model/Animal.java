package com.example.model;

public class Animal {

    private int noOflegs;
    private String animalName;

    public Animal() {}

    public Animal(int noOflegs, String animalName) {
        this.noOflegs = noOflegs;
        this.animalName = animalName;
    }

    public int getNoOflegs() {
        return noOflegs;
    }

    public void setNoOflegs(int noOflegs) {
        this.noOflegs = noOflegs;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
}
