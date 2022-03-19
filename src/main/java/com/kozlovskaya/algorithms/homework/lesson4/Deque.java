package com.kozlovskaya.algorithms.homework.lesson4;

public interface Deque<E> extends Queue<E> {

    boolean insertFirst(E value);

    boolean insertLast(E value);

    E removeFirst();

    E removeLast();

    class Node<E> {
        E item; // элемент списка
        Node<E> next; // ссылка на следующий элемент
        Node<E> previous;

    }
}
