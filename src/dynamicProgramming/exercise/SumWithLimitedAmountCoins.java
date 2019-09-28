package dynamicProgramming.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class SumWithLimitedAmountCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> coins = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        Set<List<Integer>> combinations = new HashSet<>();

        System.out.println(findAll(coins, target, new ArrayList<>(), 0,  combinations));
    }

    private static int findAll(List<Integer> coins, int target, List<Integer> usedCoins,
                               int index, Set<List<Integer>> combinations){
        int sum = 0;
        for (int coin : usedCoins) {
            sum += coin;
        }
        if(sum == target){
            combinations.add(usedCoins);
            return 1;
        }
        if(sum >= target){
            return 0;
        }
        for (int i = index; i < coins.size() ; i++) {
            int currentCoin = coins.get(i);
            List<Integer> alreadyUsed = new ArrayList<>(usedCoins);
            alreadyUsed.add(currentCoin);

           findAll(coins, target, alreadyUsed, i + 1, combinations);
        }

        return combinations.size();
    }
}
