package sortingAndSearchingAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bf.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        insertionSort(input);
        Arrays.stream(input).forEach(el ->
                System.out.printf("%d ", el));
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > num) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = num;
        }
    }
}
