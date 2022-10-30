package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] x = {{7,42},
                     {3,12},
                     {4,40},
                     {5,25}};

        System.out.println(Arrays.toString(BottomUp(4)));
        Knapsack(x,10);

    }
    public static void Knapsack(int[][] x,int limit){
        String[] s = greyCode(x.length);
        int max=0;
        String max_subset="";
        for(String i: s){
            int weight = 0, points=0;
            for (int j = 0; j <i.length(); j++) {
                if (i.charAt(j)=='1') {
                    weight += x[j][0];
                    points += x[j][1];
                }
            }
            if (weight<=limit && points>max) {
                max = points;
                max_subset = i;
            }
        }
        System.out.println(max);
        System.out.println(max_subset);

    }
    public static String[] BottomUp(int n){
        if (n==1)
            return new String[]{"0","1"};
        String[] prev = BottomUp(n-1);
        String[] curr = new String[prev.length*2];
        int index = 0;
        for (String s: prev)
            curr[index++] = s + "0";
        for (String s : prev)
            curr[index++] = s + "1";
        return curr;
    }
    public static String[] greyCode(int n){
        if (n==1)
            return new String[]{"0","1"};
        String[] prev = greyCode(n-1);
        String[] curr = new String[prev.length*2];
        int index= 0;
        for (String s: prev)
            curr[index++] = "0"+s;
        for (int i=prev.length-1;i>=0;i--)
            curr[index++] = "1"+prev[i];
        return curr;
    }

}
