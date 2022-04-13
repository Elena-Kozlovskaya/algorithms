package com.kozlovskaya.algorithms.homework.lesson5.BackpackTask;

import java.util.ArrayList;
import java.util.List;

public class SolutionApp {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Laptop", 3, 500));
        items.add(new Item("Clock", 1, 300));
        items.add(new Item("Umbrella", 1, 10));
        items.add(new Item("Glasses", 3, 10));
        items.add(new Item("Smartphone", 2, 70));

        Backpack backpack = new Backpack(5);
        backpack.findBestItems(items);
        backpack.printResult();
    }

}
