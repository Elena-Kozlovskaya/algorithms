package com.kozlovskaya.algorithms.homework.lesson4;

public class SimpleLinkedListImpl <E> implements LinkedList<E>{

    protected int size;
    protected Node<E> firstElement; // default == null

    @Override
    public void insertFirst(E value) {
        firstElement = new Node<>(value, firstElement);
        /*Node<E> actualFirst = firstElement;
        Node<E> newFirstElement = new Node<>(value, actualFirst);
        this.firstElement = newFirstElement;*/
        size++;

    }

    @Override
    public E removeFirst() {
        //проверили, что список не пустой
        if(isEmpty()){
            return null;
        }
        Node<E> removedNode = firstElement; //определили элемент для удаления
        firstElement = removedNode.next; //переназначили первый элемент
        removedNode.next = null; // удаляем связь со следующим элементом у удаляемого элемента
        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> previous = null;
        Node<E> current = firstElement;

        while (current != null){
            if (current.item.equals(value)){
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null){
            return false;
        }

        if (current == firstElement){
            removeFirst();
            return true;
        }

        previous.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    private Node<E> indexOf(E value) {
        Node<E> current = firstElement;

        while (current != null){
            if(current.item.equals(value)){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
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

    @Override
    public E getFirst() {
        return firstElement.item;
    }
}
