package com.company;

import java.util.Arrays;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
        var v = new HashMap<Integer,Integer>();
        //int[] x = {6,13,5,19,10,7,17,15,4,20,28};
        int[] x = {89,74,63,45,51,40,47,24,23,25,31,27,39,37};
        MaxHeap h = new MaxHeap(x.length);
        h.insert(x);
        h.print();h.delete();
        h.print();

    }
    public static int[] sort(int[] in){
        MinHeap m = new MinHeap(in);
        int[] res = new int[in.length];
        for (int i =0;i<in.length;i++){
            res[i] = m.min();
            m.delete();
        }
        return res;
    }
}



