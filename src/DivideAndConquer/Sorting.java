package DivideAndConquer;

import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
        int j = l;
        int k = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] < a[l]) {
                j++;
                exch(a, i, j);
            }
            else if (a[i] == a[l]) {
                k++;
                exch(a, k + j, i);
            }
        }
        exch(a, k + j, l);

        int m1 = j;
        int m2 = k + j;
        return new int[]{m1, m2};
    }

    private static int partition2(int[] a, int lo, int hi) {
        int j = lo;
        for (int i = lo + 1; i <=hi; i++) {
            if (a[i] < a[lo]) {
                j++;
                exch(a, i, j);
            }
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(int i, int v) {
        return i < v;
    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        //use partition3
        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
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


