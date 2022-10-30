// package fakeCoin;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println((fakeCoin(1842, 142)));

    }

    public static int fakeCoin(int coins, int fakeIndex) {
        int[] coinsArray = genCoins(coins, fakeIndex);
        for (int i = coinsArray.length; i >= 0; i /= 2) {
            if (coinsArray.length == 1)
                return coinsArray[0];
            int max = coinsArray.length % 2 == 0 ? coinsArray.length : coinsArray.length - 1;
            int[] arr1 = Arrays.copyOfRange(coinsArray, 0, coinsArray.length / 2);
            int[] arr2 = Arrays.copyOfRange(coinsArray, coinsArray.length / 2, max);
            int sum1 = Arrays.stream(arr1).sum();
            int sum2 = Arrays.stream(arr2).sum();
            if (sum1 == sum2)
                return coinsArray[coinsArray.length - 1];
            coinsArray = sum1 < sum2 ? arr1 : arr2;
        }
        return -1;
    }

    public static int[] genCoins(int coins, int fakeIndex) {
        int[] c = new int[coins];
        Arrays.fill(c, 10);
        c[fakeIndex] = 9;
        return c;
    }
}
