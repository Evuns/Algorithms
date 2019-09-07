package sortingAndSearchingAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Needles {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String data = bf.readLine();

        int [] array = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [] needles = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        insert(array,needles);
    }

    private static void insert(int [] array, int [] needles){
        int [] positions = new int[needles.length];

        for (int i = 0; i < needles.length ; i++) {
            int needle = needles[i];
            for (int j = array.length - 1; j >= 0 ; j--) {
                int compareTo = array[j];
                if(compareTo != 0 && compareTo < needle){
                    positions[i] = j + 1;
                    break;
                }
            }
        }
        Arrays.stream(positions).forEach(el ->
                System.out.printf("%d ", el));
    }
}
