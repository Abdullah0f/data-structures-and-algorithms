package com.company;

public class BST {
    Node root;

    public BST() {
        root = null;
    }
    public void insert(int x){
        Node n = new Node(x);
        if (root == null)
            root=n;
        else{
            Node p = root;
            Node p2 = null;

            while (p != null) {
                p2=p;
                if (x < p.data)
                    p = p.left;
                else if (x > p.data)
                    p = p.right;
                else
                    return;
            }
            if (x<p2.data)
                p2.left=n;
            else
                p2.right=n;

        }
    }
    public void add2(int x){
        Node n = new Node(x);
        if (root == null)
            root=n;
        else {
            Node p = root;
            while (true){
                if (x<p.data) {
                    if (p.left == null) {
                        p.left = n;
                        break;
                    } else
                        p = p.left;
                }
                else if (x>p.data){
                    if (p.right == null){
                        p.right=n;
                        break;
                    }
                    else
                        p=p.right;
                }
                else
                    return;
        }
        }

    }
    private void in(Node start){
        if (start!=null) {
            in(start.left);
            System.out.println(start.data+" ");
            in(start.right);
        }
    }
    public void inorder(){
        in(root);
    }
}
