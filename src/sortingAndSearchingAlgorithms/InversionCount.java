package sortingAndSearchingAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InversionCount {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        insertionSort(0, input, 0);
    }

    private static void insertionSort(int index, int[] array, int counter) {
        if (index == array.length) {
            System.out.println(counter);
        } else {
            for (int i = index; i < array.length; i++) {
                if (array[i] < array[index]) {
                    counter++;
                }
            }
            insertionSort(index + 1, array, counter);
        }
    }
}
