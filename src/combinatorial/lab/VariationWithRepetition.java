package combinatorial.lab;

import java.util.Arrays;
import java.util.Scanner;

public class VariationWithRepetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] input = scanner.nextLine().replaceAll("\\s+","").toCharArray();
        int variations = Integer.parseInt(scanner.nextLine());
        char [] print = new char[variations];

        variation(input, print, 0);
    }

    private static void variation(char [] input, char [] print, int index ){
        if(index == print.length){
            System.out.println(Arrays.toString(print).replaceAll("[\\[\\],]", ""));
            return;
        }

        for (char c : input) {
            print[index] = c;
            variation(input, print, index + 1);
        }
    }
}
