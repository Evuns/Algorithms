package recursion.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split("\\s+");
        System.out.println(reverse(input,input.length - 1));

    }

    public static String reverse(String[] input, int index) {
        if (index < 0) {
            return "";
        }
        return input[index] + " " + reverse(input, index - 1);

    }
}
