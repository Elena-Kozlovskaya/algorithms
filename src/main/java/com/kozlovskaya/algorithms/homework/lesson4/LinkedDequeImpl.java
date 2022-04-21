package com.kozlovskaya.algorithms.homework.lesson4;

public class LinkedDequeImpl<E> implements Deque<E> {
    protected int size;
    protected Node<E> firstElement; // default == null
    protected Node<E> lastElement; // default == null


    @Override
    public boolean insertFirst(E value) {
        if(value != null){
        Node<E> newFirstElement = new Node<>();
        newFirstElement.item = value;
        if(firstElement != null){
            newFirstElement.next = firstElement;
            firstElement.previous = newFirstElement;
        }
        this.firstElement = newFirstElement;

        if(lastElement == null){
            this.lastElement = firstElement;
        }
        size++;
            return true;
        }
        return false;

    }

    @Override
    public boolean insertLast(E value) {
        if(value != null) {
            Node<E> newLast = new Node<>();
            newLast.item = value;
            if (lastElement != null) {
                newLast.previous = lastElement;
                lastElement.next = newLast;
            }
            lastElement = newLast;
            if(firstElement == null){
                firstElement = lastElement;
            }
            size++;
            return true;
        }
        return false;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return  null;
        }
            Node<E> removedLast = lastElement;
            lastElement = removedLast.previous;
            if(lastElement == null){
                firstElement = null;
            } else {
                lastElement.next = null;
            }
        size--;
        return removedLast.item;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
             return  null;
        }
            Node<E> removedFirst = firstElement;
            firstElement = firstElement.next;
            if (firstElement == null) {
                lastElement = null;
            } else {
                firstElement.previous = null;
            }
            size--;
        return removedFirst.item;
    }

    @Override
    public boolean insert(E value) {
        insertLast(value);
        return true;
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public E peekFront() {
        if(isEmpty()){
            return null;
        }
        return firstElement.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node<E> current = firstElement;

        while (current != null){
            stringBuilder.append(current.item);
            if(current.next != null){
                stringBuilder.append("->");
            }
            current = current.next;
        }
        return stringBuilder.append("]").toString();
    }
}
