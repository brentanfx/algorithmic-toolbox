package DynamicProgramming;

public class RecursiveChange {
    public static int recursiveChange(int change, int[] coins, int[] lookup) {
        if (change == 0)
            return 0;
        int minimumChange = Integer.MAX_VALUE;
        int numberOfCoins = 0;
        for (int i = 0; i < coins.length; i++) {
            if (change >= coins[i]) {
                if (lookup[change - coins[i] + 1] != 0) {
                    numberOfCoins = lookup[change - coins[i] + 1];
                }
                else {
                    numberOfCoins = recursiveChange(change - coins[i], coins, lookup) + 1;
                    lookup[change - coins[i] + 1] = numberOfCoins;
                }
                if (numberOfCoins < minimumChange)
                    minimumChange = numberOfCoins;
            }
        }
        return minimumChange;
    }

    public static void main(String[] args) {
        int[] coins = {6,5,1};
        int[] lookup = new int[5 + 1];
        System.out.println(recursiveChange(5, coins, lookup));
    }

}
