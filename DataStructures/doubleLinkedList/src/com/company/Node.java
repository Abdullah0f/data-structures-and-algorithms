package com.company;

public class Node<E>{
    E data;
    Node<E> next;
    Node<E> previous;
    public Node(E data){
        this.data = data;
        next = null;
        previous = null;
    }
}
