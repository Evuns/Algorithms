package sortingAndSearchingAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(bf.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        mergeSort(input, input.length);
        Arrays.stream(input).forEach(el ->
                System.out.printf("%d ",el));
    }

    private static void mergeSort(int[] input, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        System.arraycopy(input, 0, l, 0, mid);
        System.arraycopy(input, mid, r, 0, n - mid);
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(input, l, r, mid, n - mid);
    }

    private static void merge(
            int[] input, int[] leftPart, int[] rightPart, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (leftPart[i] <= rightPart[j]) {
                input[k++] = leftPart[i++];
            } else {
                input[k++] = rightPart[j++];
            }
        }
        while (i < left) {
            input[k++] = leftPart[i++];
        }
        while (j < right) {
            input[k++] = rightPart[j++];
        }
    }
}