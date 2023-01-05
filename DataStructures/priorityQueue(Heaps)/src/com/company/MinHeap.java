package com.company;



import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int heapSize;
    public MinHeap(int capacity){
        heap = new int[capacity+1];
        heapSize=0;
    }
    public MinHeap(int[] input){
        heap = new int[100];
        heapSize=input.length;
        for(int i = 1 ; i<=heapSize; i++)
            heap[i] = input[i-1];
        heapify();
    }
    public int min(){
        return heap[1];
    }
    public int parent(int i){
        return i/2;
    }
    public int rightChild(int i){
        return 2*i+1;
    }
    public int leftChild(int i){
        return 2*i;
    }
    public int lastParent(){
        return heapSize/2;
    }
    public boolean isFull(){
        return heapSize==heap.length-1;
    }
    public boolean isEmpty(){return heapSize==0;}
    public void percolateUp(int i){
        int temp = heap[i];
        while(parent(i)>0&&temp<heap[parent(i)]) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = temp;
    }
    public void insert(int x){//insert one element
        if (isFull())
            return;
        heap[++heapSize] = x;
        percolateUp(heapSize);
    }
    public void insert(int[] x){//xxxxxxxxxxxxxxxxxxxxxx //insert a whole array
        if ((heap.length-1-heapSize) < x.length )
            return;
        for (int i : x) {
            insert(i);
        }
    }
    public void initialInsert(int  [] x){//xxxxxxxxxxxxxxxx //insert without sorting, you should use heapify() after
        if ((heap.length-1-heapSize) < x.length )
            return;
        for (int i : x) {
            heap[++heapSize] = i;
        }
    }
    public int minChild(int i){
        if(heap[leftChild(i)] < heap[rightChild(i)])
            return leftChild(i);
        return rightChild(i);
    }
    public void percolateDown(int i){
        int temp = heap[i];
        int child;
        while (leftChild(i)<=heapSize){
            if (rightChild(i)<=heapSize) //if rightchild exist
                child = minChild(i);
            else child = leftChild(i);
            if (temp>heap[child]){
                heap[i] = heap[child];
                i = child;
            }
            else break;
        }
        heap[i] = temp;
    }

    public void delete(){
        if(!isEmpty()){
            heap[1] = heap[heapSize--];
            heap[heapSize+1] = 0;
            percolateDown(1);
        }
    }

    public void heapify(){
        for (int i = lastParent(); i>0;i--){
            percolateDown(i);
        }
    }
    public void print(){//xxxxxxxxxxxxxxxxxxxxxxx
        System.out.println(Arrays.toString(heap));
    }

}
