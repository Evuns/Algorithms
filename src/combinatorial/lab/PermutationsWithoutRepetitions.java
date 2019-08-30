package combinatorial.lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PermutationsWithoutRepetitions {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = bf.readLine().split("\\s+");

        int n = elements.length;

        for (int i = 0; i < n; i++) {
            String[] permute = new String[n];
            boolean[] used = new boolean[n];
            permute[0] = elements[i];
            used[i] = true;
            findAll(elements, permute, used, 1);
        }

    }

    private static void findAll(String[] elements, String[] permute, boolean[] used, int current) {
        if (current == elements.length) {
            System.out.println(String.join(" ", permute));
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    permute[current] = elements[i];
                    findAll(elements, permute, used, current + 1);
                    used[i] = false;
                }
            }
        }


    }
}
