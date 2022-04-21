package com.kozlovskaya.algorithms.homework.lesson2;

import java.util.Arrays;

public class SelectionSort {

    public static void sort(Notebook[] arr){
        Long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = min+1; j < arr.length; j++) {
                if (arr[j].getPrice() < arr[min].getPrice()){
                    min = j;
                } else if (arr[j].getPrice() == arr[min].getPrice()){
                   if(arr[j].getRam() < arr[min].getRam()){
                       min = j;
                   } else if (arr[j].getRam() == arr[min].getRam()) {
                       if (arr[j].getManufacturer().compareTo(arr[min].getManufacturer()) < 0) {
                           min = j;
                       }
                   }
                }
            }
            Notebook temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
          //  System.out.println("i: " +  i + Arrays.toString(arr));
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
