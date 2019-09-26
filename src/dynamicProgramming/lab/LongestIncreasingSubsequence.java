package dynamicProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        findSubsequence(input);
    }

    private static void findSubsequence(int[] input) {
        int[] lengths = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                if (input[j] < input[i]) {
                        max = Integer.max(max,lengths[j] + 1);
                }
            }
            if (max == -1) {
                lengths[i] = 1;
            } else {
                lengths[i] = max;
            }
        }

        int longestSub = -1;
        int index = -1;
        for (int i = 0; i < lengths.length; i++) {
            if (lengths[i] > longestSub) {
                longestSub = lengths[i];
                index = i;
            }
        }

        StringBuilder path = new StringBuilder(input[index] + " ");
        int result = longestSub - 1;
        int previousIndex = input.length - 1;
        for (int i = index - 1; i >= 0; i--) {
            if (lengths[i] == result) {
                for (int j = 0; j < i; j++) {
                    if (lengths[j] == result && input[previousIndex] > input[j]) {
                        i = j;
                    }
                }
                path.insert(0, input[i] + " ");
                previousIndex = i;
                result--;
            }
        }
        System.out.println(path);
    }
}