package com.company;



import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int heapSize;
    public MaxHeap(int capacity){
        heap = new int[capacity+1];
        heapSize=0;
    }
    public MaxHeap(int[] input){
        heap = new int[100];
        heapSize=input.length;
        for(int i = 1 ; i<=heapSize; i++)
            heap[i] = input[i-1];
        heapify();
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
        while(parent(i)> 0&&temp>heap[parent(i)]) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = temp;
    }
    public void insert(int x){
        if (isFull())
            return;
        heap[++heapSize] = x;
        percolateUp(heapSize);
    }
    public void insert(int[] x){ //xxxxxxxxxxxxxxxxxxxxxxxx //insert a whole array
        if ((heap.length-1-heapSize) < x.length )
            return;
        for (int i : x) {
            insert(i);
        }
    }
    public void initialInsert(int  [] x){//xxxxxxxxxxxxxxxxxxxx
        if ((heap.length-1-heapSize) < x.length )
            return;
        for (int i : x) {
            heap[++heapSize] = i;
        }
    }
    public int maxChild(int i){
        if(heap[leftChild(i)] > heap[rightChild(i)])
            return leftChild(i);
        return rightChild(i);
    }
    public void percolateDown(int i){
        int temp = heap[i];
        int child;
        while (leftChild(i)<=heapSize){
            if (rightChild(i)<=heapSize) //if rightchild exist
                child = maxChild(i);
            else child = leftChild(i);
            if (temp<heap[child]){
                heap[i] = heap[child];
                i = child;
            }
            else break;
        }
        heap[i] = temp;
    }
    public int max(){
        return heap[1];
    }
    public void delete(){
        if(!isEmpty()){
            heap[1] = heap[heapSize--];
            percolateDown(1);
            heap[heapSize+1] = 0;
        }
    }
    public void heapify(){
        for (int i = lastParent(); i>0;i--){
            percolateDown(i);
        }

    }
    public void print(){//xxxxxxxxxxxxxxxxxxxxxxxxxxxx
        System.out.println(Arrays.toString(heap));
    }

}
