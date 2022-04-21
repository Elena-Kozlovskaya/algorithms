package com.kozlovskaya.algorithms.homework.lesson2;


public class SortApp {

    public static void main(String[] args) {
        Notebook[] array = new Notebook[10000];
        /*array[0] = new Notebook("Asos", 101, 23);
        array[1] = new Notebook("Bsos", 102, 22);
        array[2] = new Notebook("Csos", 103, 21);;
        array[3] = new Notebook("Dsos", 104, 20);;*/

        for(int i = 0; i <= array.length-1; i++){
            array[i] = new Notebook();
        }
        SelectionSort.sort(array);
    }
}
