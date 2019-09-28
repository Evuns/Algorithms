package dynamicProgramming.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumWithUnlimitedAmountOfCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> coins = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int target = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        System.out.println( sum(coins, target, new ArrayList<Integer>(), counter, 0));
    }

    private static int sum(List<Integer> coins, int target, List<Integer> usedCoins, int counter, int index) {
        int sum = 0;
        for (int coin : usedCoins){
            sum += coin;
        }
        if (sum == target) {
            return  1;
        }
        if (sum >= target) {
            return 0;
        }
        for (int i = index; i < coins.size(); i++) {
            int currentCoin = coins.get(i);
            List<Integer> alreadyUsed = new ArrayList<>(usedCoins);
            alreadyUsed.add(currentCoin);
            counter += sum(coins, target, alreadyUsed, 0, i);
        }
        return counter;
    }

}
