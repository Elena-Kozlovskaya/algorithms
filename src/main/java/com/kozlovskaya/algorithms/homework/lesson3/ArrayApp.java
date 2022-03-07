package com.kozlovskaya.algorithms.homework.lesson3;

public class ArrayApp {
    public static void main(String[] args) {
        int[] firstArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};
        int[] secondArray = {1, 2, 4, 5, 6};
        int[] thirdArray = {};

        System.out.println("The missing number is: " + findMissingNumber(firstArray));
    }

    public static int findMissingNumber(int[] array) {
        int result = 0;
        if (array.length == 0) {
            return result = 1;
        }
        if (array[0] == 1) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] != array[i + 1] - 1) {
                    result = array[i] + 1;
                }
            }
        }
        return result;
    }
}
