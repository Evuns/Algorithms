package combinatorial.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PermutWithoutRepetitions {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine().replaceAll("\\s+", "");
        char[] elements = input.toCharArray();
        int n = elements.length;

        permute(elements, 0, n - 1);
    }

    private static void permute(char[] elements, int start, int end) {
        if (start == end) {
            for (char el : elements) {
                System.out.print(el + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i <= end; i++) {
                elements = swap(elements, start, i);
                permute(elements, start + 1, end);
                elements = swap(elements, start, i);
            }
        }
    }

    private static char[] swap(char[] elements, int i, int j) {
        char temp;
        temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
        return elements;
    }
}

