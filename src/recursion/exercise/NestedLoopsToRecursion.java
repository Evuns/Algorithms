package recursion.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NestedLoopsToRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] vector = new int[n];
        generate(vector, 0);
    }

    private static void generate(int[] vector, int index) {
        if (index >= vector.length) {
            print(vector);
        } else {
            for (int i = 1; i <= vector.length; i++) {
                vector[index] = i;
                generate(vector, index + 1);
            }
        }
    }

    private static void print(int[] vector) {
        System.out.println(Arrays.toString(vector).replaceAll("\\[|]|\\s+", "").replaceAll(",", " "));
    }
}
