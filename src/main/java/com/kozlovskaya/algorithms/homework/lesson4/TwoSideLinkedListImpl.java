package com.kozlovskaya.algorithms.homework.lesson4;

public class TwoSideLinkedListImpl <E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E>{
    protected Node<E> last;

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if(size == 1){
            last = firstElement;
        }
    }

    @Override
    public void insertLast(E value) {
        if(isEmpty()){
            insertFirst(value);
            return;
        }

        Node<E> newNode = new Node<>(value, null);
        last.next = newNode;
        last = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();

        if(isEmpty()){
            last = null;
        }
        return removedValue;
    }

    @Override
    public boolean remove(E value) {
        Node<E> previous = null;
        Node<E> current = firstElement;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == firstElement) {
            removeFirst();
            return true;
        }
        if (current == last) {
            last = previous;
            last.next = null;
        }

        previous.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public E getLast() {
        return last.item;
    }
}
