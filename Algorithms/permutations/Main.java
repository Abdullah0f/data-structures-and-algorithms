// package permutations;

// package permutations;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(minimalChange(4)));
    }

    public static String[] minimalChange(int n) {
        if (n == 1)
            return new String[] { "1" };
        String[] prev = minimalChange(n - 1);
        String[] permutations = new String[prev.length * n];
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

}
