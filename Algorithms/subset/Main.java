// package subset;

import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(greycode(4)));

    }

    public static String[] subset(int n) {
        if (n == 1)
            return new String[] { "{}", "{1}" };
        var old = subset(n - 1);
        var subsets = new String[old.length * 2];
        int index = 0;
        for (int i = 0; i < old.length; i++) {
            subsets[index++] = old[i];
            if (old[i].length() == 2)
                subsets[index++] = "{" + n + "}";
            else
                subsets[index++] = old[i].substring(0, old[i].length() - 1) + ", " + n + "}";
        }
        return subsets;
    }

    public static String[] greycode(int n) {
        if (n == 1)
            return new String[] { "0", "1" };

        String[] prev = greycode(n - 1);
        var prevRev = reverse(prev);
        var subsets = new String[prev.length * 2];
        int index = 0;
        for (int i = 0; i < prev.length; i++)
            subsets[index++] = "0" + prev[i];
        for (int i = 0; i < prev.length; i++)
            subsets[index++] = "1" + prevRev[i];
        return subsets;

    }

    public static String[] reverse(String[] a) {
        String[] b = new String[a.length];
        int j = a.length;
        for (int i = 0; i < a.length; i++, j--)
            b[j - 1] = a[i];
        return b;
    }
}
