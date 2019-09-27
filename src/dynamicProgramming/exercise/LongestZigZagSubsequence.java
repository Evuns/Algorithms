package dynamicProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class LongestZigZagSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        findSubsequence(numbers);
    }

    private static void findSubsequence(int[] numbers) {
        boolean[] upOrDown = new boolean[2];
        if (numbers[0] > numbers[1]) {
            upOrDown[0] = true;
        } else {
            upOrDown[1] = true;
        }
        int[] lengths = new int[numbers.length];
        lengths[0] = 1;
        lengths[1] = 2;
        for (int i = 2; i < numbers.length; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                if (upOrDown[0]) {
                    if (numbers[j] < numbers[j + 1]) {
                        max = Integer.max(max, lengths[j] + 1);
                        upOrDown[0] = false;
                        upOrDown[1] = true;
                    }
                } else {
                    if (numbers[j] > numbers[j + 1]) {
                        max = Integer.max(max, lengths[j] + 1);
                        upOrDown[0] = true;
                        upOrDown[1] = false;
                    }
                }
                if (max == -1) {
                    lengths[i] = 1;
                } else {
                    lengths[i] = max;
                }
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

        StringBuilder path = new StringBuilder(numbers[index] + " ");
        int result = longestSub - 1;
        int previousNum = numbers.length - 1;
        for (int i = index - 1; i >= 0; i--) {
            if (lengths[i] == result) {
                for (int j = 0; j < i; j++) {
                    if (lengths[j] == result && numbers[j] > previousNum) {
                        i = j;
                    }
                }
                path.insert(0, numbers[i] + " ");
                previousNum = numbers[i];
                result--;
            }
        }
        System.out.println(path);
    }
}

