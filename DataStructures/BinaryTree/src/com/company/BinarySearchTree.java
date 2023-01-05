package com.company;

import java.util.Iterator;

public class BinarySearchTree{
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int x){
        root = addHelper(x,root);
    }
    private Node addHelper(int x, Node p){
        if (p == null)
            return new Node(x);
        if (x<p.data)
            p.left = addHelper(x,p.left) ;
        else if (x>p.data)
            p.right = addHelper(x,p.right);
        return p; //return the same node if its not null
    }

    public Node find(int x, Node start){
        if (start==null||start.data==x)
            return start;
        if (x < start.data)
            return find(x,start.left);
        return find(x, start.right);
    }
    public void remove(int x){
        root = removeHelper(x,root);
    }
    private Node removeHelper(int x,Node p){
        if (p==null)
            return null;

        //iterate over the tree until finding x
        if (x<p.data)
            p.left = removeHelper(x,p.left) ;
        else if(x>p.data)
            p.right = removeHelper(x,p.right);


        //if p.data==p
        else{
            if (p.right == null) //if right is null then make this node equals the left(even if its null)
                return p.left;
            if(p.left == null)
                return p.right;

            int data = smallestInRight(p.right).data; //this method returns smallest node in right
            removeHelper(data, p);
            p.data = data;
        }
        return p;
    }
    private Node smallestInRight(Node p){
        if (p.left==null)
            return p;
        return smallestInRight(p.left);
    }

    private void in(Node start){
        if (start!=null) {
            in(start.left);
            System.out.print(start.data+" ");
            in(start.right);
        }
    }
    public void inorder(){
        in(root);
        System.out.println();
    }
    private void post(Node start){
        if (start!=null) {
            post(start.left);
            post(start.right);
            System.out.print(start.data+" ");
        }
    }
    private void pre(Node start){
        if (start!=null) {
            System.out.print(start.data+" ");
            pre(start.left);
            pre(start.right);
        }
    }
    public void postorder(){
        post(root);
        System.out.println();
    }
    public void preorder(){
        pre(root);
        System.out.println();
    }
}

