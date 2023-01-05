package com.company;

import java.util.Iterator;

public class DoubleLinkedList<E> implements Iterable<E> {
    Node<E> head;
    Node<E> tail;
    public DoubleLinkedList(){
        head = null;
        tail = null;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void addFront(E x){
        Node<E> newNode = new Node<>(x);
        if (isEmpty()){
            head=newNode;
            tail =newNode;
            return;
        }
        newNode.next = head;
        head.previous = newNode;
        head = newNode;
    }
    public void addEnd(E x){
        if (isEmpty()){
            addFront(x);
            return;
        }
        Node<E> newNode = new Node<>(x);
        tail.next=newNode;
        newNode.previous = tail;
        tail = newNode;
    }
    public void print(){
        if (isEmpty())
            return;
        Node<E> p = head;
        do{
            System.out.print(p.data+" ");
            p = p.next;
        }while (p!=null);
        System.out.println();
        int i = 1;
        p = head;
        System.out.println("head "+ head.data);
        System.out.println("tail "+ tail.data);
        do{
            if (tail==head)
                System.out.print(p.data + "    previous:"+p.previous+"   next:"+ p.next);
            else if (p==head)
                System.out.print("element:"+i+"\tdata:"+p.data+"\t  previous:"+p.previous+"\tnext:"+ p.next.data+"\n");
            else if (p==tail)
                System.out.print("element:"+i+"\tdata:"+p.data+"\t  previous:"+p.previous.data+"\tnext:"+ p.next+"\n");
            else
                System.out.print("element:"+i+"\tdata:"+p.data+"\t  previous:"+p.previous.data+"\tnext:"+ p.next.data+"\n");
            p = p.next;
            i++;
        }while (p!=null);
        System.out.println();
    }
    public void addAfter(E val, E x){
        if (isEmpty())
            return;

        Node<E> p = head;

        if (tail.data==val){
            addEnd(x);
            return;
        }
        while (p.data!=val && p.next!=null)
            p=p.next;

        if(p.data!=val)
            return;
        //the p is defiently not the last element cause if so we wont be here

        Node<E> newNode = new Node<>(x);
        newNode.next=p.next;
        newNode.previous = p;
        p.next.previous = newNode;
        p.next = newNode;

    }
    public void removeFront(){
        if (isEmpty())
            return;
        if (head==tail){
            head = null;
            tail = null;
            return;
        }
        head=head.next;
        head.previous = null;
    }
    public void removeEnd(){
        if (isEmpty())
            return;
        if (head==tail){
            removeFront();
            return;
        }
        tail = tail.previous;
        tail.next = null;
    }
    public void remove(E x){
        if (isEmpty())
            return;
        Node<E> p = head;
        while(p!=tail&&p.data!=x)
            p=p.next;

        if (p.data!=x)
            return;

        if(p==head)
            removeFront();
        else if(p==tail)
            removeEnd();
        else{
            p.previous.next = p.next;
            p.next.previous=p.previous;
        }
    }
    public void removeI(int x){
        if (isEmpty())
            return;
        Node<E> p = head;
        int i=0;
        while(p!=tail&&i!=x) {
            p = p.next;
            i++;
        }

        if (i!=x)
            return;

        if(p==head)
            removeFront();
        else if(p==tail)
            removeEnd();
        else{
            p.previous.next = p.next;
            p.next.previous=p.previous;
        }
    }
    @Override
    public Iterator<E> iterator() {
        return new ListIterator(this);
    }


    private class ListIterator implements Iterator<E> {
        DoubleLinkedList<E> list;
        Node<E> p;

        public ListIterator(DoubleLinkedList<E> x){
            list = x;
            if (!list.isEmpty())
                p = head;
        }

        @Override
        public boolean hasNext() {
            return p!=null;
        }

        @Override
        public E next() {
            E data = p.data;
            p=p.next;
            return data;
        }
    }
}
