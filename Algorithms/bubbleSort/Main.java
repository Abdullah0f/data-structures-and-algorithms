import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        int[] x = { 3, 5, 7, 4, 2, 1, 6, 8, 9, 10 };
        bubbleSort(x);
        System.out.println(Arrays.toString(x));
    }

    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}