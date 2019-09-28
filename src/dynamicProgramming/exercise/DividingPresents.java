package dynamicProgramming.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DividingPresents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] presents = Arrays.copyOf(input,input.length);
        List<Integer> Bob = new ArrayList<>();
        List<Integer> Alan = new ArrayList<>();

        divideInEqualSums(presents, Bob, Alan);
        printResults(Alan, input);
        System.out.printf("%nBob takes the rest.");
    }

    private static void divideInEqualSums(int[] presents, List<Integer> Bob, List<Integer> Alan) {
        Arrays.sort(presents);
        int sumBob = 0;
        int sumAlan = 0;

        for (int i = presents.length - 1; i >= 0; i--) {
            if (sumBob <= sumAlan) {
                Bob.add(presents[i]);
                sumBob += presents[i];
            } else {
                Alan.add(presents[i]);
                sumAlan += presents[i];
            }
        }
        System.out.println("Difference: " + Math.abs(sumBob - sumAlan));
        System.out.println("Alan:" + sumAlan + " Bob:" + sumBob);
    }

    static void printResults(List<Integer> Alan, int[] presents) {

        System.out.print("Alan takes: ");
        for (int i = presents.length - 1; i >= 0; i--) {
            if(Alan.contains(presents[i])) {
                int index = Alan.indexOf(presents[i]);
                System.out.print(presents[i] + " ");
                Alan.remove(index);
            }
        }
    }
}