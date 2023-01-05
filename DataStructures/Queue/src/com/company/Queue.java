package com.company;

import java.util.Iterator;

public class Queue implements Iterable<Integer> {
    int[] list;
    int front,back,size;

    public Queue(int size){
        this.size=size+1;
        list = new int[this.size];
        front = 0;
        back = -1;
    }

    public boolean isEmpty(){
        return (back+1)%size==(front%size);
    }

    public boolean isFull(){
        return (back+2)% size == (front%size);
    }

    public void enqueue(int data){
        if (isFull())
            return;
        back = (back+1)%size;
        list[back] = data;
    }
    public int dequeue(){
        if (isEmpty())
            return -1;
        int t = list[front];
        front= (front+1)%size;
        return t;
    }

    public Integer getFront() {
        if (isEmpty())
            return null;
        return list[front];
    }

    public void print(){
        for(int i=front;i<=back;i++)
            System.out.print(list[i]+" ");
        System.out.println();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ListIterator(this);
    }


    private class ListIterator implements Iterator<Integer> {
        Queue queue;
        int p;
        public ListIterator(Queue x){
            queue = x;
            if (!queue.isEmpty())
                p = front;
        }

        @Override
        public boolean hasNext() {
            return (p<=back);
        }

        @Override
        public Integer next() {
            return queue.list[p++];
        }
    }
}
