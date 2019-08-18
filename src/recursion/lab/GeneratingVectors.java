package recursion.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GeneratingVectors {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] vector = new int[n];

        generate(0, vector);
    }

   private static void generate(int index, int[] vector) {
        if (index >= vector.length) {
            print(vector);
        } else {
            for (int i = 0; i <= 1; i++) {
                vector[index] = i;
                generate(index + 1, vector);
            }
        }
    }

    static void print(int[] vector) {
        System.out.println(Arrays.toString(vector).replaceAll("\\[|,|\\]|\\s+", ""));
    }
}
