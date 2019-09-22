package combinatorial.lab;

import java.math.BigInteger;
import java.util.Scanner;

public class BinomialCoefficients {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());
        //n!/k!(n-k)!
        //3!/2!(3-2)! = 6/2=3

        BigInteger first = factorial(n);
        BigInteger second = factorial(k);
        BigInteger sum = factorial(n - k);
        System.out.println(first.divide(second.multiply(sum)));
    }

    private static BigInteger factorial(int number) {
        if (number == 1) {
            return BigInteger.valueOf(1);
        }
        return BigInteger.valueOf(number).multiply(factorial(number - 1));

    }
}
