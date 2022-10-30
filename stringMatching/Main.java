class Main {
    public static void main(String[] args) {
        stringMatching("NOBODY NOTICED HIM", "NOT");
    }

    public static void stringMatching(String text, String pattern) {
        for (int i = 0; i < text.length() - pattern.length(); i++) {
            boolean found = true;
            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }

}
