package com.kozlovskaya.algorithms.homework.lesson4;

public interface TwoSideLinkedList<E> extends LinkedList<E>{

    void insertLast(E value);

    // добавление элемента после заданного индекса
    void insertAfter(int index, E value);

    E getLast();
}
