package com.kozlovskaya.algorithms.homework.lesson5.BackpackTask;

import java.util.*;

public class Backpack {
    private List<Item> resultSet = null;
    private int maxWeight;
    private int highestCost;

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    private int calculateWeight(List<Item> items){
        int sum = 0;
        for(Item i : items){
            sum += i.getWeight();
        }
        return sum;
    }

    private int calculateCost(List<Item> items){
        int sum = 0;
        for(Item i : items){
            sum += i.getCost();
        }
        return sum;
    }

    private void checkItems(List<Item> items){
        if (resultSet == null)
        {
            if(calculateWeight(items) <= maxWeight){
                resultSet = items;
                highestCost = calculateCost(items);
            }
        } else if (calculateWeight(items) <= maxWeight && calculateCost(items) > highestCost){
                resultSet = items;
                highestCost = calculateCost(items);
        }
    }

    public void findBestItems(List<Item> items){
        if(items.size() > 0)
            checkItems(items);
        for(int i = 0; i < items.size(); i++){
            List<Item> newItems = new ArrayList<>(items);
            newItems.remove(i);
            findBestItems(newItems);
        }
    }

    public List<Item> getResultSet() {
        return resultSet;
    }

    public void printResult(){
        List<Item> items = getResultSet();
        for(Item i : items){
            System.out.println("Name: " + i.getName() + "; Weight: " + i.getWeight() + "; Cost: " + i.getCost());
        }
    }
}
