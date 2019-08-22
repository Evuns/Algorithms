package recursion.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CombinationWithRepetition {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int toNumber = Integer.parseInt(bf.readLine());
        int byCombination = Integer.parseInt(bf.readLine());

        int[] vector = new int[byCombination];
        generate(vector,toNumber,0, 1);
    }

    private static void generate(int[]vector, int toNumber, int index, int border){
        if(index >= vector.length){
            print(vector);
        }else{
            for (int i = border; i <= toNumber ; i++) {
                vector[index] = i;
                generate(vector,toNumber,index + 1, i );
            }
        }
    }

    private static void print(int[]vector){
        System.out.println(Arrays.toString(vector)
                .replaceAll("\\[|]|,", ""));
    }
}
