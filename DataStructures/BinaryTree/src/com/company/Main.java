package com.company;

public class Main {

    public static void main(String[] args) {
        var x = new s();
        x.insert(8);          //8
        x.insert(3);       //3   /10
        x.insert(10);
        x.remove(8);
        x.insert(1);     //1  /6     /14
        x.insert(6);       //4 /7  //13
        x.insert(4);
        x.insert(7);
        x.insert(10);
        x.insert(14);
        x.insert(13);
        x.inorder();

//        x.postorder();
//        x.preorder();
////        Node a = (x.find(4, x.root));
//        x.remove(3);
//        x.remove(6);

    }
}
