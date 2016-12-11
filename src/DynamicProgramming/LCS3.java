package DynamicProgramming;

import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        int[][][] dist = new int[a.length + 1][b.length + 1][c.length + 1];
        /*
        for (int i = 0; i <= a.length; i++) {
            dist[i][0] = i;
        }
        for (int i = 0; i <= b.length; i++) {
            dist[0][i] = i;
        } */
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                for (int k = 1; k <= c.length; k++) {
                    if (a[i-1] == b[j - 1] && b[j - 1] == c[k - 1]) {
                        dist[i][j][k] = max(dist[i-1][j][k], dist[i][j-1][k] , dist[i][j][k-1], dist[i-1][j-1][k-1] + 1);
                    }
                    else dist[i][j][k] = max(dist[i-1][j][k], dist[i][j-1][k] , dist[i][j][k-1], dist[i-1][j-1][k-1]);
                }
            }
        }
        return dist[a.length][b.length][c.length];
        //return Math.min(Math.min(a.length, b.length), c.length);
    }

    private static int max(int a, int b, int c, int d) {
        int arr[] = new int[4];
        arr[0] = a;
        arr[1]= b;
        arr[2] = c;
        arr[3] = d;
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }

    private static int max(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        }
        else if (b >= a && b >= c) {
            return b;
        }
        else return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}
