package com.company;

import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        var x = new LinkedList<Integer>();
        String str2 = "fsafa";
        char[] arr = new char[str2.length()];
//        x.addFront(30);
//        x.addFront(20);
//        x.addFront(10);
//        x.addAfter(20,25);
        Collections.addAll(x,1,2,3,4);
       var y = new LinkedList<Integer>();
       Collections.addAll(y,1,2,3,4,5);
        System.out.println(x.contains(3));
        System.out.println(y.contains(6));
        System.out.println(x.compareTo(y));
        x.print();
        x.clear();

        System.out.println();


    }
}
