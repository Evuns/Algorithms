package examPreparation;

import java.util.Scanner;

public class AbaspaBasapa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        char[] first = word.toCharArray();
        char[] second = scanner.nextLine().toCharArray();

        System.out.println(findSubstring(first, second, first.length, second.length, word));
    }

    private static String findSubstring(char[] first, char[] second, int firstL, int secondL, String word) {
        int[][] matrix = new int[firstL + 1][secondL + 1];
        int index = 0;
        int result = 0;
        for (int i = 0; i <= firstL; i++) {
            for (int j = 0; j <= secondL; j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 0;
                } else if (first[i - 1] == second[j - 1]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    if (result < matrix[i][j]) {
                        index = i;
                        result = Integer.max(result, matrix[i][j]);
                    }
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        return (word.substring(index - result, index));
    }
}
