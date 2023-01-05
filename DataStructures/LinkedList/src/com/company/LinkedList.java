package com.company;

import java.util.Collection;
import java.util.Iterator;

public class LinkedList<E> implements Collection<E>, Comparable<LinkedList<E>> { //collection implements iterable //it should implement list but im lazy
    Node<E> head;
    private int len=0;
    public LinkedList(){
        head = null;
    }
    public void addFront(E x){
        var temp = new Node<E>(x);
        temp.next = head;
        head = temp;
        len++;
    }


    public boolean isEmpty(){
        return head == null;
    }
    public void print(){
        if(isEmpty()){
            System.out.println("the list is empty");
            return;
        }
        Node<E> p = head;
        do {
            System.out.print(p.data+" ");
            p = p.next;
        }
        while (p!=null);
    }
    @Override
    public boolean add(E x){ //addEnd, boolean becasue it implements collections
        if(isEmpty()){
            addFront(x);
            return true;
        }
        Node<E> p = head;
        while (p.next!=null){
            p=p.next;
        }
        p.next = new Node<>(x);
        len++;
        return true;
    }
    public void addAfter(E val, E x){
        if (isEmpty())return;
        Node<E> p =head;
        while(p.data!=val&&p.next!=null)
            p=p.next;
        if(p.data!=val)
            return;
        Node<E> newNode = new Node<>(x);
        newNode.next=p.next;
        p.next=newNode;
        len++;
    }
    public void removeFront(){
        if (!isEmpty()) {
            head = head.next;
            len--;
        }
    }
    public void removeEnd(){
        if(!isEmpty()){
            if (head.next==null) {
                head = null;
                return;
            }
            Node<E> p = head;
            while (p.next.next!=null){
                p=p.next;
            }
            p.next=null;
            len--;
        }
    }
    @Override
    public boolean remove(Object x){ //boolean, Object instead of E, because of collections
        if (isEmpty()){
            System.out.println("element not found");
            return false;
        }
        Node<E> p = head;
        if (p.data==x)
            removeFront();
        else {
            while (p.next != null && p.next.data != x ) {
                p = p.next;
            }
            if (p.next!=null)
            p.next = p.next.next;
        }

        len--;
        return true;
    }
 ///////////////////////////for collection
    @Override
    public void clear() {
         head = null;
         len = 0;
    }


    @Override
    public boolean contains(Object o) {
        if (isEmpty())
            return false;
        Node<E> p = head;
        while (p.next!=null && p.data!=o){
            p=p.next;
        }
        return p.data == o;
    }
    @Override
    public int size() {
        return len;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E i: c)
            add(i);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
//////////////////// for comparable


    @Override
    public int compareTo(LinkedList<E> o) {
        //i will comapre list by length
        if (this.size()>o.size())
            return 1;
        else if (this.size()<o.size())
            return -1;
        return 0;
    }

    //////////////////////////////////for iterable
    @Override
    public Iterator<E> iterator() {
        return new ListIterator(this);
    }


    private class ListIterator implements Iterator<E> {
        LinkedList<E> list;
        Node<E> p;

        public ListIterator(LinkedList<E> x) {
            list = x;
            if (!list.isEmpty())
                p = head;
        }

        @Override
        public boolean hasNext() {
            return p != null;
        }

        @Override
        public E next() {
            E data = p.data;
            p = p.next;
            return data;
        }
    }


}
