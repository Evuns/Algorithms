package sortingAndSearchingAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bf.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        quickSort(input, input.length / 2);

    }

    private static void quickSort(int[] array, int middle) {
        int pilot = array[middle];
        List<Integer> smaller = new ArrayList<>();
        List<Integer> larger = new ArrayList<>();

        for (int value : array) {
            if (value <= pilot) {
                smaller.add(value);
            } else {
                larger.add(value);
            }
        }
        smaller.sort(Integer::compareTo);
        larger.sort(Integer::compareTo);
        System.out.print(smaller.toString().replaceAll("\\[|]|,", ""));
        System.out.print(" " + larger.toString().replaceAll("\\[|]|,", ""));
    }
}

