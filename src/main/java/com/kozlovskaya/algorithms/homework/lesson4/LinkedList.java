package com.kozlovskaya.algorithms.homework.lesson4;

public interface LinkedList <E>{

    void insertFirst(E value);

    E removeFirst();

    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();

    E getFirst();

    class Node<E> {
        E item; // элемент списка
        Node<E> next; // ссылка на следующий элемент

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
