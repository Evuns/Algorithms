package dynamicProgramming.lab;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [] result = new int[n];

        System.out.println(fibonacci(result, n - 1));
    }

    private static int fibonacci(int [] result, int n){
        if(n <= 1){
            return 1;
        }
        if(result[n - 1] != 0){
            return result[n - 1];
        }

        result[n - 1] = fibonacci(result, n - 1) + fibonacci(result, n - 2);
        return (result[n - 1]);
    }
}
