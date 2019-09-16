package combinatorial.lab;

import java.util.*;

public class PermutationWithRepetitions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        String s = scanner.nextLine().replaceAll("\\s+","");
        printDistinctPermut(s, "");
    }
    private static void printDistinctPermut(String str, String ans) {
        if (str.length() == 0) {
            for (int i = 0; i <ans.length() ; i++) {
                System.out.print(ans.charAt(i) + " ");
            }
            System.out.println();
            return;
        }
        boolean[] alpha = new boolean[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            if (!alpha[ch - 'A'])
                printDistinctPermut(ros, ans + ch);
            alpha[ch - 'A'] = true;
        }
    }
}