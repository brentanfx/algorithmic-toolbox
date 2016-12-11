package GreedyAlgorithm;

import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int k = n;
        int l = 1;
        while (k > 2 * l) {
            summands.add(l);
            k-=l;
            l++;
        }
        summands.add(k);
        return summands;
    }

    private static List<Integer> myOptimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int k = (int) Math.sqrt (2 * n);

        int rem = (2 * n) % k;
        for (int i = 1; i < k; i++) {
            summands.add(i);
        }
        summands.add(k + rem);
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}
