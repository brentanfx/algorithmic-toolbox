package Week2;

import java.util.Scanner;

/**
 * Created by Brentan on 11/5/2016.
 */
public class GCD {
    private static int naiveGCD(int a, int b) {
        int gcd = 1;
        for (int i = Math.min(a, b); i > 1; i--) {
            if ( a % i == 0 && b % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    private static int euclideanGCD(int a, int b) {
        if (b == 0)
            return a;
        return euclideanGCD(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = euclideanGCD(a, b);
        System.out.println(c);
    }
}
