package GreedyAlgorithm;

import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        //write your code here
        int numOfTens = m / 10;
        int remaining = m % 10;
        int numOfFives = remaining / 5;
        remaining %= 5;
        return numOfTens + numOfFives + remaining;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}


