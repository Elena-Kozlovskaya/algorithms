package com.kozlovskaya.algorithms.homework.lesson2;

public class Notebook {
    private String manufacturer;
    private int price;
    private int ram;

    public Notebook(String manufacturer, int price, int ram) {
        this.manufacturer = manufacturer;
        this.price = (int) (Math.random() * ((2000 - 500) + 1)) + 500;
        this.ram = (int) Math.random();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }
}

