package DivideAndConquer;


import java.util.Scanner;

public class MergeSort {
    public static int sort(int[] a, int[] b, int left, int right) {
        int numberOfInversions = 0;
        if (left >= right)
            return 0;
        int mid = left + ((right - left) / 2);
        numberOfInversions += sort(a, b, left, mid);
        numberOfInversions += sort(a, b, mid + 1, right);
        return numberOfInversions + merge(a, b, left, mid, right);
    }

    private static int merge(int[] a, int[] b, int left, int mid, int right) {
        int numOfInversions = 0;
        System.arraycopy(a, left, b, left, right + 1 - left);
        int i = left, j = mid + 1;
        int k = left;
        while ( i <= mid && j <= right) {
            if (b[i] <= b[j]) {
                a[k++] = b[i++];
            }
            else {
                a[k++] = b[j];
                numOfInversions++;
                for (int l = i + 1; l <= mid; l++) {
                    if (a[l] > a[j])
                        numOfInversions++;
                    else
                        break;
                }
                j++;
            }
        }

        while (i <= mid)
            a[k++] = b[i++];

        while (j <= right)
            a[k++] = b[j++];

        return numOfInversions;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        int num = sort(a, b, 0, a.length - 1);
        System.out.println(num);
    }
}
