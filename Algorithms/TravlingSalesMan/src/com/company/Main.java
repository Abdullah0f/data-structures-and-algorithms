package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Graph x = new Graph();
//        x.addNode("a");
//        x.addNode("b");
//        x.addNode("c");
//        x.addNode("d");
//        x.addEdge("a","b",2);
//        x.addEdge("a","d",5);
//        x.addEdge("a","c",8);
//        x.addEdge("b","c",3);
//        x.addEdge("b","d",4);
//        x.addEdge("c","d",7);
//        TSP(x);
//        JohnsonTrotter("1234");
        for (int i=0;i<2*2*2*2*2*2  ;i++) {
            System.out.println(addLeftPadding(Integer.toString(decimalToBinary(i)),6));
        }
    }
    public static int decimalToBinary(int n){
        if (n==0)
            return 0;
        else
            return (n%2+10*decimalToBinary(n/2));
    }

    public static String addLeftPadding(String s,int n){
        int len = s.length();
        if (len==n)
            return s;
        else
            return addLeftPadding("0"+s,n);
    }
    public static void TSP(Graph x){
        char max = Collections.max(x.nodes.keySet(),String.CASE_INSENSITIVE_ORDER).charAt(0);
//        System.out.println(Arrays.toString(per));
        String[] permutations = minimalChange(max);
        String[][] edges = edges(permutations);
        int min = Integer.MAX_VALUE;
        String path="";
        for (int i=0;i<edges.length;i++) {
            int sum = 0;
            for (int j = 0; j < edges[0].length; j++)
                sum+=x.getWeight(edges[i][j]);
            if (sum<min){
                min = sum;
                path = 'a'+permutations[i]+'a';
            }
            System.out.println('a'+permutations[i]+'a');
            System.out.println("Weight: "+sum);

        }

        System.out.println("\nBEST");
        System.out.println("Path:"+path);
        System.out.println("Weight: "+min);



    }
    public static String[][] edges(String[] p){
        String[][] x =new String[p.length][p[0].length()+1];
//        System.out.println(Arrays.deepToString(x));
        for (int i =0;i< x.length;i++)
            for (int j=0;j<x[0].length;j++){
                if (j==0)
                    x[i][j]="a"+p[i].charAt(j);
                else if (j==x[0].length-1)
                    x[i][j] = p[i].charAt(j-1)+"a";
                else
                    x[i][j]= p[i].charAt(j-1)+String.valueOf(p[i].charAt(j));
            }
        return x;

    }
    public static String[] minimalChange(char n) {
        if (n == 'b')
            return new String[] { "b" };
        String[] prev = minimalChange((char) (n - 1));
        String[] permutations = new String[prev.length * (n-97)];
        int index = 0;


        for (int i = 0; i < prev.length; i++) {
            String num = prev[i];
            if (i % 2 == 0)
                for (int j = num.length(); j >= 0; j--)
                    permutations[index++] = num.substring(0, j) + n + num.substring(j);
            else
                for (int j = 0; j <= num.length(); j++)
                    permutations[index++] = num.substring(0, j) + n + num.substring(j);

        }
        return permutations;

    }
    public static void JohnsonTrotter(String n){
        char[] x = n.toCharArray();
        Set<Character> right = new HashSet<>();
        Set<Character> left = new HashSet<>();
        for (char i: x)
            left.add(i);

        while (true){
//            find max
            char max = x[0];
            int maxIndex=0;
            for (int i=1;i<x.length;i++)
                if (x[i]>max)
                    maxIndex=i;
           if (left.contains(max)){

           }

               while (maxIndex<x.length&&maxIndex>0){

               }
        }

//        System.out.println(Arrays.toString(x));
    }
    public static void swap(char[]x,int i ,int j){
        char a = x[i];
        x[i] = x[j];
        x[j] = a;
    }
}
