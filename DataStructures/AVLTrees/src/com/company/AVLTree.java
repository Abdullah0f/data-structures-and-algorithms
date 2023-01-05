package com.company;

public class AVLTree {
    private class Node{
        private Node left;
        private Node right;
        private int value;
        private int height;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return
                    "value=" + value;
        }
    }
    Node root;

    public AVLTree() {
        this.root = null;
    }
    public void insert(int value){
        root = insert(root,value);
    }
    private Node insert(Node p,int value){
        if (p==null)
            return new Node(value);
        if (value>p.value)
            p.right = insert(p.right,value);
        else if (value< p.value)
            p.left = insert(p.left,value);
        calcHeight(p);

       return balance(p);
//        return p;
    }
    private Node leftRotate(Node p){
        Node x = p.right;
        p.right = x.left;
        x.left = p;
        calcHeight(p);
        calcHeight(x);
        return x;

    }
    private Node rightRotate(Node p){
        Node x = p.left;
        p.left = x.right;
        x.right = p;
        calcHeight(p);
        calcHeight(x);
        return x;
    }

    private Node balance(Node p){
        if (isRightHeavy(p)) {
            if (balanceFactor(p.right) > 0)
                p.right = rightRotate(p.right);
            return leftRotate(p);
        }
        else if(isLeftHeavy(p)) {
            if (balanceFactor(p.left) < 0)
                p.left = leftRotate(p.left);
            return rightRotate(p);
        }
        return p;
    }
    private void calcHeight(Node p){
        p.height = Math.max(height(p.right),height(p.left)) + 1;
    }
    private boolean isRightHeavy(Node p){
        return balanceFactor(p)<-1;
    }
    private boolean isLeftHeavy(Node p){
        return balanceFactor(p)>1;
    }
    private int balanceFactor(Node p){
        return height(p.left)-height(p.right);
    }
    private int height(Node p){
        return p==null?-1:p.height;
    }
    public void inorder(){
        inorder(root);
        System.out.println();
    }
    private void inorder(Node p){
        if (p.left!=null)
            inorder(p.left);
        System.out.print(p.value+" ");
        if (p.right!=null)
            inorder(p.right);
    }

}
