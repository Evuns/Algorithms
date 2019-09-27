package dynamicProgramming.exercise;

import java.util.Scanner;

public class BinomialCoefficients {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());
        int first = findFactorial(n);
        int second = findFactorial(k);
        int result = findFactorial(n - k);

        System.out.println(first / (second * result));
    }

    private static int findFactorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * findFactorial(n - 1);

    }
}
