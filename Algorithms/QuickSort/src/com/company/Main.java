package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = { 6, 34, 63, 7, 3, 46, 5, 34, 23, 364 };
        quickSort(arr, 0, arr.length, 2, 3);
        System.out.println(Arrays.toString(arr));

        test();

    }

    public static void quickSort(int[] arr, int left, int right, int partitioning, int pivot) {
        if (right - left <= 1)
            return;

        int p = switch (pivot) {
            case 2 -> medianOfThree(arr, left, right);
            case 3 -> (int) (Math.random() * (right - left) + left);
            default -> left;
        };
        swap(arr, p, left);

        int s = partitioning == 1 ? lomuto(arr, left, right) : hoare(arr, left, right);

        quickSort(arr, left, s, partitioning, pivot);
        quickSort(arr, s + 1, right, partitioning, pivot);

    }

    public static int hoare(int[] arr, int left, int right) {
        int pivot = left;
        int i = left;
        int j = right - 1;

        while (true) {
            while (i < right - 1 && arr[i] <= arr[pivot])
                i++;

            while (j > left && arr[j] >= arr[pivot])
                j--;
            if (i >= j) {
                swap(arr, j, pivot);
                break;
            }
            swap(arr, i, j);
        }

        return j;
    }

    public static int lomuto(int[] arr, int left, int right) {
        int pivot = left;
        int s = left;
        for (int i = left; i < right; i++)
            if (arr[i] < arr[pivot])
                swap(arr, ++s, i);
        swap(arr, s, pivot);
        return s;
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

    }

    public static int medianOfThree(int[] arr, int left, int right) {
        int x = Math.max(Math.min(arr[left], arr[right / 2]),
                Math.min(Math.max(arr[left], arr[(left + right) / 2]), arr[right - 1]));
        return x == arr[left] ? left : x == arr[right - 1] ? right - 1 : (left + right) / 2;
    }

    public static void test() {
        boolean[] results = new boolean[1000];
        for (int y = 0; y < results.length; y++) {
            int[] arr = new int[10];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * 100); // storing random integers in an array
            }
            int[] b = arr.clone();
            Arrays.sort(b);
            quickSort(arr, 0, arr.length, 2, 1);
            boolean same = true;
            for (int q = 0; q < arr.length; q++) {
                if (arr[q] != b[q])
                    same = false;
            }
            results[y] = same;
        }
        for (boolean x : results)
            if (!x)
                System.out.println(x);

    }
}
