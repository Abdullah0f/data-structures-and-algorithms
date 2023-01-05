package com.company;

public class List<E> {
    Node<E> head;
    public List(){
        head = null;
    }
    public void addFront(E x){
        Node<E> temp = new Node<>(x);
        temp.next = head;
        head = temp;
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
    public void addEnd(E x){
        if(isEmpty()){
            addFront(x);
            return;
        }
        Node<E> p = head;
        while (p.next!=null){
            p=p.next;
        }
        p.next = new Node<E>(x);
    }
    public E getHead(){
        if (isEmpty())
            return null;
        return head.data;
    }
    public void addAfter(E val, E x){
        if (isEmpty()){
            System.out.println("the list is empty");
            return;}
        boolean found=false;
        Node<E> p = head;
        do{
            if(p.data==val) {
                found = true;
                break;
            }
            p=p.next;
        }while (p!=null);
        if (found) {
            Node<E> newNode = new Node<>(x);
            newNode.next = p.next;
            p.next = newNode;
        }
        else
            System.out.println("value is not found");
    }
    public void removeFront(){
        if (!isEmpty())
            head = head.next;
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
        }
    }
    public void remove(E x){
        if (isEmpty()){
            System.out.println("element not found");
            return;
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


    }
}
