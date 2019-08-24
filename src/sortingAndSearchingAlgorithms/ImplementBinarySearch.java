package sortingAndSearchingAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ImplementBinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int [] input = Arrays.stream(bf.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int number = Integer.parseInt(bf.readLine());
        search(input, number,input.length / 2);

    }

    private static void search(int[] input, int number, int i){
        if(input.length == 1 & number != input[0]){
            System.out.println(-1);
            return;
        }
        if(input[i] == number){
            System.out.println(i);
            return;
        } else{
            if(input [i] > number){
                int [] left = new int[i];
                for (int j = 0; j < i ; j++) {
                    left[j] = input[j];
                }
                search(left, number,left.length / 2);
            } else{
                int [] right = new int[input.length - i];
                    int index = 0;
                for (int j = i; j < input.length ; j++) {
                    right[index] = input[j];
                    index++;
                }
                search(right, number,right.length / 2);
            }
        }
    }
}
