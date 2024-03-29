package DynamicProgramming;

import java.util.*;

public class KnapsackDP {
    static int optimalWeight(int W, int[] w) {
        int[][] result = new int[w.length + 1][W + 1];
        for (int i = 1; i <= w.length; i++) {
            for (int weight = 1; weight <= W; weight++) {
                result[i][weight] = result[i-1][weight];
                if (weight >= w[i - 1]) {
                    int maxWeight = result[i-1][weight - w[i - 1]] + w[i-1];
                    if (maxWeight > result[i][weight]) {
                        result[i][weight] = maxWeight;
                    }
                }
            }
        }
        return result[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

