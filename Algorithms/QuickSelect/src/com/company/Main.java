package com.company;

public class Main {

    public static void main(String[] args) {
        int[] x = {4,3,7,5,6,9,8}; //3,4,5,6,7,8,9
        System.out.println(quickSelect(x,1));
    }
    public static int quickSelect(int[] arr, int k){
        int index = k-1;
        int left = 0;
        int right = arr.length;
        int s = lomuto(arr,left,right);
        while(s!=index){
            if (s>index)
                right = s;
            else
                left = s + 1;

            s=lomuto(arr,left,right);
        }
        return arr[index];
    }
    public static int hoare(int[] arr,int left, int right) {
        int pivot = left;
        int i = left;
        int j = right-1;

        while (true) {
            while (i<right-1 && arr[i] <= arr[pivot])
                i++;

            while (j>left && arr[j] >= arr[pivot])
                j--;
            if (i >= j) {
                swap(arr, j, pivot);
                break;
            }
            swap(arr, i, j);
        }

        return j;
    }
    public static int lomuto(int[] arr, int left, int right){
        int pivot = left;
        int s=left;
        for (int i = left; i < right; i++)
            if (arr[i]<arr[pivot])
                swap(arr,++s,i);
        swap(arr,s,pivot);
        return s;
    }

    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

    }
}