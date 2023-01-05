package com.company;

public class s {
    int size;
    int front;
    int rear;
    int [] arr;
    public s(int size){
        this.size = size+1;
        arr = new int[this.size];
        front = 0;
        rear = -1;
    }
    boolean empty(){
        if((rear+1)%size == front)
            return true;
        return false;
    }
    boolean full(){
        if((rear+2)%size == front)
            return true;
        return false;
    }
    void enqueue(int x){
        if(!full()){
            rear = (rear+1)%size;
            arr[rear]= x;
        }
    }
    void dequeue(){
        if(!empty()){
            front = (front+1)%size;
        }
    }
    int getFront(){
        if(empty()){
            return -1;
        }else{
            return arr[front];
        }
    }

}