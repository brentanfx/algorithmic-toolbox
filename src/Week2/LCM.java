package Week2;

import java.util.Scanner;

/**
 * Created by Brentan on 11/5/2016.
 */
public class LCM {
    private static long lcm(int a, int b) {
        long lcm = 1;
        for (long i = 1; i < (long) a * b; i++) {
            if (i % a == 0 && i % b == 0) {
                lcm = i;
                break;
            }
        }
        return lcm;
    }

    private static long gcdFast(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdFast(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        long c =  a * b / gcdFast(a, b);
        System.out.println(c);
    }
}
