package recursion.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class GeneratingCombinations {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bf.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int length = Integer.parseInt(bf.readLine());
        int[] vector = new int[length];

        generateCombinations(input, vector, 0, 0);

    }

    private static void generateCombinations(int[] input, int[] vector, int index, int border) {
            if (index >= vector.length) {
                print(vector);
            } else {
                for (int i = border; i < input.length; i++) {
                    vector[index] = input[i];
                    generateCombinations(input, vector, index + 1, i + 1);

                }
            }
    }

    private static void print(int[] vector) {
        System.out.println(Arrays.toString(vector).replaceAll("\\[|,|\\]", ""));
    }
}
