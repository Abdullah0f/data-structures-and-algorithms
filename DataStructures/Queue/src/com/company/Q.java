package com.company;

public class Q {
    int[] q;
    int back, front, n;
    public Q(int c){
        q = new int[c+1];
        n=c+1;
        back=-1;
        front=0;
    }
    public boolean isEmpty(){
        return (back+1)%n == front%n;
    }
    public boolean isFull(){
        return (back+2)%n == front;
    }
    public void enq(int x){
        if (isFull())
            return;
        back = (back+1)%n;
        q[back] = x;
    }
    public int deq(int x){
        if (isEmpty())
            return -1;
        int t = q[front];
        front =(front+1)%n;
        return t;
    }
}
