package sortingAndSearchingAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Searching {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(bf.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int number = Integer.parseInt(bf.readLine());

        for (int i = 0; i < input.length ; i++) {
            if(input[i] == number ){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
