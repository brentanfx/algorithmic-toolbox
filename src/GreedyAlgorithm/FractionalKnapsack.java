package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        List<LootElement> elements = new ArrayList<LootElement>();
        //write your code here
        for (int i = 0; i < values.length; i++) {
            elements.add(new LootElement(values[i], weights[i]));
        }
        Collections.sort(elements);

        for (LootElement element : elements) {
            if (capacity == 0)
                break;
            int weight = Math.min(capacity, element.weight);
            value += element.worth * weight;
            capacity -= weight;
        }

        return value;
    }

    private static class LootElement implements Comparable<LootElement>{
        private int weight;
        private float worth;

        LootElement(int value, int weight) {
            this.weight = weight;
            this.worth = ((float) value) / weight;
        }

        @Override
        public int compareTo(LootElement o) {
            return (int) (o.worth - worth);
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
