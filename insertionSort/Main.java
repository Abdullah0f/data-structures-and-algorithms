import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] x = { 3, 5, 7, 4, 2, 1, 6, 8, 9, 10 };
        insertionSort(x);
        System.out.println(Arrays.toString(x));
    }

    public static int[] insertionSort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            int current = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > current) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = current;
        }
        return a;
    }
}