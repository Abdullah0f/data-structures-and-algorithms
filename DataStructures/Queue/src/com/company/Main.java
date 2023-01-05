package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    var x = new Queue(5);
        for (int i=0; i<5;i++) {
            x.enqueue(i + 1);
        }
        for (int i:x) {
            System.out.println(i);
        }

//        for (int i=0; i<5;i++) {
//            x.dequeue();
//            x.print();
//        }
//        x.enqueue(5);
//        x.print();
//        System.out.println(x);
    }
    public static <T extends Comparable<T>> T max(T first, T second){
        return first.compareTo(second)<0 ? second : first;
    }
}
