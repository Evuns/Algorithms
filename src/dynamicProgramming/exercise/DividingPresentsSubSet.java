package dynamicProgramming.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DividingPresentsSubSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] presents = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int totalSum = Arrays.stream(presents).sum();

        int[] sum = new int[totalSum + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = -1;
        }
        for (int i = 0; i < presents.length; i++) {
            for (int j = totalSum - presents[i]; j >= 0; j--) {
                if (sum[j] != -1 && sum[j + presents[i]] == -1) {
                    sum[j + presents[i]] = i;
                }
            }
        }
        int halfSum = totalSum / 2;
        for (int i = halfSum; i >= 0; i--) {
            if (sum[i] == -1) {
                continue;
            }
            System.out.println("Difference: " + (totalSum - i - i));
            System.out.println("Alan:" + i + " Bob:" + (totalSum - i));
            System.out.print("Alan takes: ");
            while(i != 0){
                System.out.print(presents[sum[i]] + " ");
                i -= presents[sum[i]];
            }
            System.out.printf("%nBob takes the rest.");
        }
    }
}
