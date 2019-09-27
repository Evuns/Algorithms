package dynamicProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;

public class RodCutting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] prices = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rodLength = Integer.parseInt(scanner.nextLine());
        int [] bestPrice = new int[prices.length];
        int [] bestCombo = new int[prices.length];
       cutRod(rodLength,bestPrice,prices,bestCombo);
    }

    private static void cutRod(int n, int [] bestPrice, int [] prices, int[] bestCombo){
        for (int i = 1; i <= n ; i++) {
            int currentBest;
            for (int j = 1; j <= i ; j++) {
                currentBest = Math.max(bestPrice[i], prices[j] + bestPrice[i - j]);
                if (currentBest > bestPrice[i]) {
                    bestPrice[i] = currentBest;
                    bestCombo[i] = j;
                }
            }
        }
        System.out.println(bestPrice[n]);

        while(n - bestCombo[n] != 0) {
            System.out.print(bestCombo[n] + " ");
            n = n - bestCombo[n];
        }
        System.out.println(bestCombo[n]);
    }
}
