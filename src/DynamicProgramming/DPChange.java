package DynamicProgramming;

public class DPChange {
    public static int dpChange(int change, int[] coins) {
        int[] minChange = new int[change + 1];
        minChange[0] = 0;
        for (int i = 1; i <= change; i++) {
            minChange[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin) {
                    int min = minChange[i - coin] + 1;
                    if (min < minChange[i]) {
                        minChange[i] = min;
                    }
                }
            }
        }
        return minChange[change];
    }

    public static void main(String[] args) {
        int[] coins = {6,5,1};
        System.out.println(dpChange(25, coins));
    }

}