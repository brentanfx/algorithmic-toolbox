package DynamicProgramming;

import java.util.*;

class EditDistance {
    public static int editDistance(String s, String t) {
        int[][] dist = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dist[i][0] = i;
        }
        for (int i = 0; i <= t.length(); i++) {
            dist[0][i] = i;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dist[i][j] = min(dist[i-1][j] + 1, dist[i][j-1] + 1, dist[i-1][j-1]);
                }
                else dist[i][j] = min(dist[i-1][j] + 1, dist[i][j-1] + 1, dist[i-1][j-1] + 1);
            }
        }
        return dist[s.length()][t.length()];
    }

    private static int min(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        }
        else if (b < a && b < c) {
            return b;
        }
        else return c;
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(editDistance(s, t));
    }

}
