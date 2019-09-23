package combinatorial.lab;

import java.util.Arrays;
import java.util.Scanner;

public class VariationWithoutRepetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        int length = Integer.parseInt(scanner.nextLine());
        char[] print = new char[length];
        boolean[] used = new boolean[input.length];

        variate(input, print, used, 0);
    }

    private static void variate(char[] input, char[] print, boolean[] used, int index) {
        if (index == print.length) {
            System.out.println(Arrays.toString(print).replaceAll("\\[|]|,",""));
            return;
        }
        for (int i = 0; i < input.length; i++) {
            if (!used[i]) {
                print[index] = input[i];
                used[i] = true;
                variate(input, print, used, index + 1);
                used[i] = false;
            }
        }

    }
}

