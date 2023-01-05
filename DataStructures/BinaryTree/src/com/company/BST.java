package com.company;

public class BST { //iterative
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
    public void insert2(int x){
        Node n = new Node(x);
        if (root == null)
            root=n;
        else {
            Node p = root;
            while (true){ //or put while(p.data!=x) and remove last else
                if (x<p.data) {
                    if (p.left == null) {
                        p.left = n;
                        return;
                    } else
                        p = p.left;
                }
                else if (x>p.data){
                    if (p.right == null){
                        p.right=n;
                        return;
                    }
                    else
                        p=p.right;
                }
                else //if p.data=x
                    return;
            }
        }

    }
    public void remove(int x){
        Node curr = root;
        Node prev = null;
        boolean isRight=false;
        while (curr!=null && curr.data != x) {
            prev=curr;
            if (x < curr.data) {
                curr = curr.left;
                isRight=false;
            }
            else {
                curr = curr.right;
                isRight = true;
            }
        }

        if (curr==null) return; //includes if root in null
        //at this point curr is the one, and prev is the previous node

/*
//        if (curr.right==null&&curr.left==null){ //if curr is a leaf
//            if (curr==root) {  //if curr root, just delete it
//                root = null;
//                System.out.println("here");
//            }
//            else if (isRight)
//                prev.right=null;
//            else {
//                prev.left = null;
//                System.out.println("here");
//            }
//        }
        ///////else??
        //at this point curr is not a leaf

 */
        //next code can replace previous so no need to the previous
        //check if curr only has 1 child or is a leaf and deal with it
        if (curr.right==null){
            if (curr==root)
                root = curr.left;
            else if (isRight)
                prev.right= curr.left;
            else {
                prev.left = curr.left;
            }
        }

        else if (curr.left==null){
            if (curr==root)
                root = curr.right;
            else if (isRight)
                prev.right= curr.right;
            else
                prev.left = curr.right;
        }

        else {
            //at this point curr is not leaf and dosent have only 1 child, curr has TWO children
            //find most left in right
            //no need to give root a special case
            Node min = curr.right;
            Node minPrev = curr;
            while (min.left != null) {
                minPrev = min;
                min = min.left;
            }
            //min is most left in right
            curr.data= min.data;//replace curr with most left in right

            if (curr.right== min) //if min doesnt have a left from the first place
                curr.right = min.right;

            else if (min.right!=null)
                minPrev.left = min.right;
            else
                minPrev.left=null; //delete most left in right

        }
    }
    private Node max(Node start){ //find maximum of starting point //give it p.left to find most left in right but useless
        if (root==null)
            return null;
        Node p = start;
        while (p.right!=null)
            p=p.right;
        return p;
    }
    private Node min(Node start){ //find minimum of starting point
        if (root==null)
            return null;
        Node p = start;
        while (p.left!=null)
            p=p.left;
        return p;
    }
    public void remove2(int key){
        Node curr = root;
        Node prev = null;
        while(curr!=null && curr.data!=key){
            prev = curr;
            if (key< curr.data)
                curr =curr.left;
            else
                curr = curr.right;
        }
        //empty tree or val nor found
        if (curr==null) return;
        //the node have one child or none
        if (curr.left==null||curr.right==null){
            if (curr.left==null){
                // the node is root
                if (prev==null) {
                    root = curr.right;
                    return;
                }
                if (prev.left == curr)
                    prev.left=curr.right;
                else //if (prev.right == curr)
                    prev.right = curr.right;
            }
            else { //if (curr.right==null)
                // the node is root
                if (prev==null) {
                    root = curr.left;
                    return;
                }
                if (prev.left == curr)
                    prev.left=curr.left;
                else //if (prev.right == curr)
                    prev.right = curr.left;
            }
            return;
        }
        //the node has two children
        Node min = curr.right;
        Node min_prev = curr;
        while(min.left!=null){
            min_prev=min;
            min = min.left;
        }
        if (min_prev == curr)
            curr.right = min.right;
        else
            min_prev.left = min.right;
        curr.data = min.data;

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
    }
    private void post(Node start){
        if (start!=null) {
            post(start.left);
            post(start.right);
            System.out.print(start.data+" ");
        }
    }
    public void postorder(){
        post(root);
        System.out.println();
    }
    private void pre(Node start){
        if (start!=null) {
            System.out.print(start.data+" ");
            pre(start.left);
            pre(start.right);
        }
    }
    public void preorder(){
        pre(root);
        System.out.println();
    }
}
