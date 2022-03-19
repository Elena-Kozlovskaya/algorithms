package com.kozlovskaya.algorithms.homework.lesson4;



public class MainApp {
    public static void main(String[] args) {
        // testLinkedList();
        //testQueue();
        testDeque();


    }

    private static void testLinkedList(){
        TwoSideLinkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);
        linkedList.insertLast(9);
        linkedList.insertLast(10);
        linkedList.insertLast(11);
        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));

       /* System.out.println("remove first: " + linkedList.removeFirst());
        linkedList.remove(4);
        linkedList.remove(11);*/
        System.out.println(linkedList.size());
        linkedList.insertAfter(linkedList.size()-1, 24);
        linkedList.display();
        System.out.println(linkedList.size());
    }

    private static void testQueue() {

        Queue<Integer> queue = new LinkedQueue<>();

        System.out.println("add element: " + queue.insert(34));
        System.out.println("add element: " + queue.insert(12));
        System.out.println("add element: " + queue.insert(20));
        System.out.println("add element: " + queue.insert(16));
        System.out.println("add element: " + queue.insert(14));
        System.out.println("add element: " + queue.insert(17));

        queue.display();
        System.out.println("remove: " + queue.remove());
        queue.display();

    }

    private static void testDeque() {

        Deque<Integer> deque = new LinkedDequeImpl<>();

        System.out.println("add element: " + deque.insert(34));
        System.out.println("add element: " + deque.insert(12));
        System.out.println("add element: " + deque.insert(20));
        System.out.println("add element: " + deque.insert(16));
        System.out.println("add element: " + deque.insert(14));
        System.out.println("add element: " + deque.insert(17));

        deque.display();
        System.out.println("remove: " + deque.remove());
        deque.display();
        System.out.println("removeFirst: " + deque.removeFirst());
        deque.display();
        System.out.println("removeLast: " + deque.removeLast());
        deque.display();

    }
}
