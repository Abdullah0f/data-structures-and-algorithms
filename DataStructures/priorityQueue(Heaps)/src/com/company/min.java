package com.company;

import java.util.Arrays;

public class min {
    int[] heap;
    int heapSize;
    public min(int size){
        heap = new int[++size];
        heapSize = 0;
    }
    public boolean isFull(){
        return heapSize ==heap.length-1;
    }
    public int parent(int i){
        return i/2;
    }
    public int lc(int i){
        return i*2;
    }
    public int rc(int i){
        return lc(i)+1;
    }
    public int maxChild(int i){
        if (heap[lc(i)]>heap[rc(i)])
            return lc(i);
        return rc(i);
    }
    public void pu(int i){
        int temp = heap[i];
        while(parent(i)>0&&temp>heap[parent(i)]){
            heap[i] = heap[parent(i)];
            i = parent(i);
            heap[i] = temp;
        }
    }
    public void insert(int x){
        if (isFull())
            return;
        heap[++heapSize] = x;
        pu(heapSize);
    }
    public void insert(int[] x){ //insert a whole array
        if ((heap.length-1-heapSize) < x.length )
            return;
        for (int i : x) {
            insert(i);
        }
    }
    public void pd(int i){
        int temp = heap[i];
        int child;
        while (lc(i)<=heapSize){
            if (rc(i)<=heapSize)
                child = maxChild(i);
            else child=lc(i);
            if (temp<heap[child]){
                heap[i] = heap[child];
                i=child;
            }
            else break;
        }
        heap[i] =temp;
    }
    public void delete(){
        if (heapSize==0)
            return;
        heap[1] = heap[heapSize--];
        pd(1);
    }
    public void print(){
        System.out.println(Arrays.toString(heap));
    }
    public void heapify(){
        for (int i = heapSize/2;i>0;i--){
            pd(i);
        }
    }


}
