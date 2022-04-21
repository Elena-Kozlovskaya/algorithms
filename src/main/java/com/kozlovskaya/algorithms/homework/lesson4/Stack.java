package com.kozlovskaya.algorithms.homework.lesson4;

public interface Stack<E> {

    boolean push(E value);

    E pop();

    E peek(); //top()

    int size();

    boolean isEmpty();

    boolean isFull();

    void display();

}
