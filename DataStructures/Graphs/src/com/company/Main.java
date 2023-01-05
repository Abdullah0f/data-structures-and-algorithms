package com.company;

public class Main {

    public static void main(String[] args) {
	 Graph x = new Graph();
        x.addNode("A");
        x.addNode("B");
        x.addNode("C");
        x.addNode("D");
        x.addNode("E");
        x.addEdge("A","B");
        x.addEdge("A","E");
        x.addEdge("B","E");
        x.addEdge("C","A");
        x.addEdge("C","D");
        x.addEdge("D","E");
        x.addEdge("E","A");
//        x.addEdge("B","A");
//        x.print();
//        String s = Arrays.toString(x.topologicalSR());
        System.out.println(x.isAcyclic());



    }
}
