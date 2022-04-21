package com.kozlovskaya.algorithms.homework.lesson6;
//E extends Comparable<? super E> для возможности сравнения <, >, ==;
public interface Tree <E extends Comparable<? super E>> {

    // для вариантов обхода дерева в глубину
    //IN_ORDER - центрированный обход,
    // PRE_ORDER - прямой обход,
    // POST_ORDER - обратный порядок;
    enum TraversMode {
        IN_ORDER, PRE_ORDER, POST_ORDER
    }

    boolean contains(E value);

    boolean add(E value);

    boolean remove(E value);

    boolean isEmpty();

    int size();

    void display();

    void traverse(TraversMode mode);
}
