package com.company;

public class Main {

    public static void main(String[] args) {
        var x = new DoubleLinkedList<Integer>();
        x.addFront(30);
        x.addFront(20);
        x.addFront(10);
        x.addAfter(30,40);
        //x.remove(30);
        //x.removeFront();
//        System.out.println(x.head);
//        System.out.println(x.tail);
        x.print();
       // x.print();
       // System.out.println(x.head.data);
        //System.out.println(x.tail.data);
        //x.remove(20);
        //x.print();

        var y = new DoubleLinkedList<String>();
        y.addFront("hello");
        y.addEnd("world");
        y.addAfter("hello",",");
        y.print();
        

    }
}
