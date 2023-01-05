package com.company;

public class ll<E> {
    Node<E> head;

    public ll() {
        head = null;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void addFront(E data){
        Node<E> nn = new Node<>(data);
        nn.next = head;
        head = nn;
    }
    public void addEnd(E data){
        if (isEmpty())
            addFront(data);
        Node<E> nn = new Node<>(data);
        var p = head;
        while (p.next!=null)
            p=p.next;
        p.next = nn;
    }
    public void removeFront(){
        if (isEmpty())
            return;
        head = head.next;
    }
    public void removeEnd(){
        if (isEmpty())
            return;
        if (head.next==null)
            removeFront();

        var p = head;
        while(p.next.next!=null)
            p=p.next;
        p.next = null;
    }
    public void addAfter(E data){
        if (isEmpty())
            return;
        var p = head;
        while(p.next!=null&&p.data!=data)
            p=p.next;
        if (p.data!=data)
            return;
        var nn = new Node<>(data);
        nn.next = p.next;
        p.next = nn;
    }
    public void remove(E data){
        if (isEmpty())
            return;
        var p=head;
        while(p.next!=null&&p.next.data!=data)
            p=p.next;
        if (p.next==null)
            return;
        p.next = p.next.next;


    }
}
