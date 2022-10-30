import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = { 6, 4, 4, 23, 7, 8, 7, 3, 2, 9, 7, 5, 32, 3, 5, 6 };
        System.out.println(Arrays.toString(selectionSort(a)));

    }

    public static int[] selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++)
                if (a[j] < a[min])
                    min = j;
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        return a;
    }
}
