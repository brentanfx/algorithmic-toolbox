package DynamicProgramming;

import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        char[] op = new char[exp.length()/2];
        int[] digits = new int[(exp.length() / 2) + 1];
        int opCount = 0;
        int dCount = 0;
        for (char c : exp.toCharArray()) {
            if ( c == '+' || c == '-' || c == '*') {
                op[opCount++] = c;
            }
            else digits[dCount++] = Character.getNumericValue(c);
        }
        int[][] m = new int[digits.length][digits.length];
        int[][] M = new int[digits.length][digits.length];
        for (int i = 0; i < m[0].length; i++) {
            m[i][i] = digits[i];
            M[i][i] = digits[i];
        }

        for (int s = 0; s < digits.length - 1;s++) {
            for (int i = 0; i < digits.length - s - 1; i++) {
                int j = i + s + 1;
                minMax(i, j, m, M, op);
            }
        }
        return M[0][digits.length - 1];
    }

    private static void minMax(int i, int j, int[][] m, int[][] M, char[] op) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int k = i; k < j; k++) {
            int[] a = new int[4];
            a[0] = eval(M[i][k], M[k+1][j], op[k]);
            a[1] = eval(M[i][k], m[k+1][j], op[k]);
            a[2] = eval(m[i][k], m[k+1][j], op[k]);
            a[3] = eval(m[i][k], M[k+1][j], op[k]);
            min = findMin(min, a);
            max = findMax(max, a);
        }
        M[i][j] = max;
        m[i][j] = min;
        return;
    }


    private static int findMax(int max, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        return max;
    }

    private static int findMin(int min, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min)
                min = a[i];
        }
        return min;
    }

    private static int eval(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

