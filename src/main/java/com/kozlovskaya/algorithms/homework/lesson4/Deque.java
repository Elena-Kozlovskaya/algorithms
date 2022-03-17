package com.kozlovskaya.algorithms.homework.lesson4;

public interface Deque<E> extends Queue<E> {

    boolean insertFirst(E value);

    boolean insertLast(E value);

    E removeFirst();

    E removeLast();
}
