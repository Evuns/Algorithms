package recursion.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(bf.readLine());
        System.out.println(factorial(input));
    }

    private static int factorial(int num){
        if(num == 0){
            return 1;
        }
        return num * factorial(num - 1);
    }
}
