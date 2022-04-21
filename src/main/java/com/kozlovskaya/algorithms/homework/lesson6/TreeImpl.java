package com.kozlovskaya.algorithms.homework.lesson6;

import java.util.Stack;

// Бинарное дерево. левый элемент < корнень < правый элемент;
// Поиск min - левый элемент со ссылкой null на следующий левый;
// Поиск max - правый элемент со ссылкой null на следующий правый;
public class TreeImpl<E extends Comparable<? super E>> implements Tree<E>{

    private Node<E> root;
    private int size;

    // связка данных о родительском и текущем элементе
    private class NodeAndParent {
        private Node<E> current;
        private Node<E> parent;

        public NodeAndParent(Node<E> current, Node<E> parent) {
            this.current = current;
            this.parent = parent;
        }
    }


    @Override
    public boolean contains(E value) {
        NodeAndParent nodeAndParent = doFind(value);
        return nodeAndParent.current != null;
    }

    private NodeAndParent doFind(E value) {
        Node<E> current = root;
        Node<E> parent = null;

        while (current != null) {
            if(current.getValue().equals(value)){
                return new NodeAndParent(current, parent);
            }
            // спустились на уровень ниже
            parent = current;
            // сравнение значений current и value, определяем в какую сторону идти
            if(current.isLeftChild(value)){
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        return new NodeAndParent(null, parent);
    }

    @Override
    public boolean add(E value) {
        NodeAndParent nodeAndParent = doFind(value);

        if(nodeAndParent.current != null) {
  //          nodeAndParent.current.incRepeat();
            return false;
        }

        Node<E> parent = nodeAndParent.parent;
        Node<E> node = new Node<>(value);

        //если дерево пустое, корень равен новому значению
        if(isEmpty()){
            root = node;
        } else if(parent.isLeftChild(value)){
            parent.setLeftChild(node);
        } else {
            parent.setRightChild(node);
        }
        size++;

        return true;
    }

    @Override
    public boolean remove(E value) {
        NodeAndParent nodeAndParent = doFind(value);

        Node<E> parent = nodeAndParent.parent;
        Node<E> removed = nodeAndParent.current;

        if(removed == null){
            return false;
        }
        // проверка, что элемент последний
        if(removed.isLeaf()){
            removeLeafNode(removed, parent);
        } else if(removed.hasOnlyOneChild()){
            removeNodeWithOneChild(removed, parent);
        } else {
            //[1 2 3 4 5] 6 [7 8 9 10 11]
            // Задача: удалить корень 6 - найти максимальный или минимальный элемент в поддеревьях
            removeNodeWithAllChildren(removed, parent);

        }
        size--;
        return true;
    }
// Есть удаляемый узел (removed) -> будем двигаться по правой части от этого узла
    // в правом поддереве ищем min элемент
    //getSuccessor(Node<E> removed):
    // successor - удаляемый элемент;
    // его parent = null;
    // current - это следующий правый элемент от successor(removed),
    // нужен чтобы найти последний мин элемен (содержит ссылку на следующий элемент = null)
    // изначально current проверяем, что он не последний элемент и пока (current != null) ->
    // parent = successor, successor = current, current = current.getLeftChild()
    //current каждый раз спускаем ниже;
    // когда current == null и если (проверка successor не является корнем)-> parent.setLeftChild(successor.getRightChild()), successor.setRightChild(removed.getRightChild());
    // successor.setLeftChild(removed.getLeftChild());
    // работаем с парой parent и successor для замены ссылок
    // далее в методе removeNodeWithAllChildren(Node<E> removed, Node<E> parent):
    // если удаляемый элемен = root (корню), то root = successor;
    // если удаляемый элемент является левым элементом parent:
    // у parent ссылку на левый элемент заменяем ссылкой на successor,
    // иначе у parent ссылку на правый элемент заменяем ссылкой на successor


    private void removeNodeWithAllChildren(Node<E> removed, Node<E> parent) {
            Node<E> successor = getSuccessor(removed);

            if(removed == root){
                root = successor;
            } else if(parent.isLeftChild(removed.getValue())){
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
    }

    private Node<E> getSuccessor(Node<E> removed) {
        Node<E> successor = removed;
        Node<E> parent = null;
        Node<E> current = removed.getRightChild();

        while(current != null){
            parent = successor;
            successor = current;
            current = current.getLeftChild();
        }
// проверка не удаляем ли мы корень
        if(successor != removed.getRightChild() && parent != null) {
            parent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removed.getRightChild());
        }
        successor.setLeftChild(removed.getLeftChild());

        return successor;
    }

    private void removeNodeWithOneChild(Node<E> removed, Node<E> parent) {
        Node<E> child = removed.getLeftChild() != null
                ? removed.getLeftChild()
                : removed.getRightChild();

        if(removed.isLeftChild(child.getValue())) {
            removed.setLeftChild(null);
        } else {
            removed.setRightChild(null);
        }

        if(removed == root) {
            root = child;
        } else if(parent.isLeftChild(removed.getValue())){
            parent.setLeftChild(child);
        } else {
            parent.setRightChild(child);
        }
    }

    // сначала находим родителя
    private void removeLeafNode(Node<E> removed, Node<E> parent) {
        if(removed == root){
            root = null;
        } else if(parent.isLeftChild(removed.getValue())){
            parent.setLeftChild(null);
        } else {
            parent.setRightChild(null);
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void traverse(TraversMode mode) {
        switch (mode){
            case PRE_ORDER -> preOrder(root); // прямой
            case IN_ORDER -> inOrder(root); // центрированный
            case POST_ORDER -> postOrder(root); // обратный
        }
        System.out.println();
    }

    private void postOrder(Node<E> current) {
        if(current == null){
            return;
        }
        postOrder(current.getLeftChild());
        postOrder(current.getRightChild());
        System.out.print(current.getValue() + " ");
    }

    private void inOrder(Node<E> current) {
        if(current == null){
            return;
        }
        inOrder(current.getLeftChild());
        System.out.print(current.getValue() + " ");
        inOrder(current.getRightChild());
    }

    private void preOrder(Node<E> current) {
        if(current == null){
            return;
        }
        System.out.print(current.getValue() + " ");
        preOrder(current.getLeftChild());
        preOrder(current.getRightChild());
    }

    @Override
    public void display() {
        Stack<Node<E>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node<E>> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node<E> tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }
}
