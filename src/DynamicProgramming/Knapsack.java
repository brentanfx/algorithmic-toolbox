package DynamicProgramming;

public class Knapsack {

    public static void main(String[] args) {
        int[] weights = {6,3,4, 2};
        int[]values = {30, 14, 16, 9};
        System.out.println(knapsackNoRepeat(10,values,weights));
    }

    public static int knapsack(int weight, int[] values, int[] weights) {
        int value[] = new int[weight + 1];
        for (int w = 1; w <= weight; w++) {
            for (int i = 0; i < weights.length; i++) {
                if (w >= weights[i]) {
                    int maxValue = value[w - weights[i]] + values[i];
                    if (maxValue > value[w]) {
                        value[w] = maxValue;
                    }
                }
            }
        }
        return value[weight];
    }

    private static int knapsackNoRepeat(int weight, int[] values, int[] weights) {
        int[][] value = new int[weights.length + 1][weight + 1];
        for (int i = 1; i <= weights.length; i++) {
            for (int w = 1; w <= weight; w++) {
                value[i][w] = value[i-1][w];
                if (w >= weights[i-1]) {
                    int maxValue = value[i-1][w - weights[i-1]] + values[i - 1];
                    if (maxValue > value[i][w]) {
                        value[i][w] = maxValue;
                    }
                }
            }
        }
        return value[weights.length][weight];
    }
}
