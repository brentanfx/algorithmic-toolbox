package DivideAndConquer;

import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right)
            return -1;
        if (left + 1 == right) {
            return a[left];
        }
        int mid = right - ((right - left) / 2);
        int res1 = getMajorityElement(a, left, mid);
        int res2 = getMajorityElement(a, mid + 1, right);
        int count1 = 0;
        int count2 = 0;
        for (int i = left; i <= right; i++) {
            if (a[i] == res1)
                count1++;
            if (a[i] == res2)
                count2++;
        }
        if (count1 > (right - left + 1) / 2)
            return res1;
        if (count2 > (right - left + 1) / 2)
            return res2;
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length - 1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

