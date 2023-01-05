package com.company;

public class s {
    Node root;
    public s(){
        root=null;
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

    public void inorder(){
        in(root);
        System.out.println();
    }
    public void postorder(){
        post(root);
        System.out.println();
    }
    public void preorder(){
        pre(root);
        System.out.println();
    }
    public void in(Node p){
        if(p==null)
            return;
        in(p.left);
        System.out.print(p.data+" ");
        in(p.right);
    }
    public void post(Node p){
        if(p==null)
            return;
        in(p.left);
        in(p.right);
        System.out.print(p.data+' ');
    }
    public void pre(Node p){
        if(p==null)
            return;
        System.out.print(p.data+' ');
        in(p.left);
        in(p.right);
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


}
