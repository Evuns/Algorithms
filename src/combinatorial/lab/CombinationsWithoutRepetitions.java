package combinatorial.lab;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationsWithoutRepetitions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));

        char[] input = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        int combine = Integer.parseInt(scanner.nextLine());
        char[] print = new char[combine];
        boolean[] used = new boolean[input.length];
        combinations(input, print, 0, 0);

    }

    private static void combinations(char[] input, char[] print, int index, int start) {
        if (index == print.length) {
            System.out.println(Arrays.toString(print).replaceAll("\\[|]|,", ""));
            return;
        }
        for (int i = start; i < input.length; i++) {
            print[index] = input[i];
            combinations(input, print, index + 1, i + 1);
        }
    }
}
