package sortingAndSearchingAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bf.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        bubbleSort(input);
        Arrays.stream(input).forEach(el ->
                System.out.printf("%d ", el));
    }

    private static void bubbleSort(int [] array){
        int temp;
        for (int i = 0; i < array.length ; i++) {
            for (int j = 1; j < array.length; j++) {
                if(array[j - 1] > array [j]){
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
