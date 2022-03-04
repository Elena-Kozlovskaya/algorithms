package com.kozlovskaya.algorithms.homework.lesson2;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Notebook {
    private String manufacturer;
    private int price;
    private int ram;

    public Notebook() {
        this.manufacturer = generateManufacturer();
        this.price = (int) Math.floor(Math.floor(Math.random() * (2000 - 500) + 500) / 50) * 50;
        this.ram = (int) Math.floor(Math.floor(Math.random() * (24 - 4) + 4) / 4) * 4;
    }

    public Notebook(String manufacturer, int price, int ram) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.ram = ram;
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

    private String generateManufacturer(){
        List<String> manufacturers = Arrays.asList("Lenovo", "Asos", "MacNote", "Eser", "Xamiou");
        Random random = new Random();
        return manufacturers.get(random.nextInt(manufacturers.size()));
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", ram=" + ram +
                '}';
    }
}

