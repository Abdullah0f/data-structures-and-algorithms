package com.company;

import java.util.Iterator;

public class Stack<E> implements StackADT<E>, Iterable<E>{
    Node<E> head;

    public Stack(){
        head = null;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void push(E x){
        Node<E> temp = new Node<>(x);
        temp.next = head;
        head = temp;
    }
    public E pop(){
        if (isEmpty())
            return null;
        E tmp = head.data;
        head = head.next;
        return tmp;
    }
    public E top(){
        if (isEmpty())
            return null;
        return head.data;
    }
    public void print(){
        if (isEmpty())
            return;
        Node<E> p = head;
        do{ //print the whole list without details
            System.out.print(p.data+" ");
            p = p.next;
        }while (p!=null);

        System.out.println();
//
//        int i = 1; //counter for the elements
//        p = head;
//        System.out.println("head "+ head.data);
//
//        do{
//            if (p.next==null)
//                System.out.printf("element:%-5d data:%-7s next:"+ p.next+"\n",i,p.data);
//            else
//                System.out.printf("element:%-5d data:%-7s next:%-7s\n",i,p.data,p.next.data);
//            i++;
//            p=p.next;
//        }while (p!=null);
//        System.out.println();
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator(this);
    }


    private class ListIterator implements Iterator<E> {
        Stack<E> stack;
        Node<E> p;

        public ListIterator(Stack<E> x){
            stack = x;
            if (!stack.isEmpty())
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

