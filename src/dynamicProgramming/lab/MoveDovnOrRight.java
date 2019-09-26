package dynamicProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;

public class MoveDovnOrRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] result = new int[rows][cols];
        result[0][0] = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j != 0) {
                    result[0][j] = result[0][j - 1] + matrix[0][j];
                }
                if (j == 0 && i != 0) {
                    result[i][0] = result[i - 1][0] + matrix[i][0];
                }
                if (i != 0 && j != 0) {
                    result[i][j] = Integer.max(result[i][j - 1], result[i - 1][j]) + matrix[i][j];
                }
            }
        }

        int currentRow = rows - 1;
        int currentCol = cols - 1;
        StringBuilder path = new StringBuilder("[" + currentRow + ", " + currentCol + "]" + " ");

        while (currentRow >= 0 && currentCol >= 0) {
            if (currentRow > 0 && currentCol > 0) {
                if (result[currentRow - 1][currentCol] > result[currentRow][currentCol - 1]) {
                    currentRow -= 1;
                } else {
                    currentCol -= 1;
                }
            } else if (currentRow > 0) {
                currentRow -= 1;
            } else {
                currentCol -= 1;
            }
            path.insert(0, "[" + currentRow + ", " + currentCol + "]" + " ");
            if (currentRow == 0 && currentCol == 0) {
                break;
            }
        }
        System.out.println(path);
    }
}