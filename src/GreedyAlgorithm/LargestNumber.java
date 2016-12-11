package GreedyAlgorithm;

import java.util.*;

public class LargestNumber implements Comparator<String>{
    private static String largestNumber(String[] a) {
        String result = "";
        for (int j = 0; j < a.length; j++) {
            String max = "0";
            int maxPos = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i].equals("-1"))
                    continue;
                if (isGreaterOrEqualTo(a[i], max)) {
                    max = a[i];
                    maxPos = i;
                }
            }
            result += max;
            a[maxPos] = "-1";
        }
        return result;
    }

    private static String myLargestNumber(String[] a) {
        String result = "";
        Arrays.sort(a, new LargestNumber());
        for (int i = a.length - 1; i >= 0; i--) {
            result += a[i];
        }
        return result;
    }

    private static boolean isGreaterOrEqualTo(String a, String b) {
        String aPlusb = a.concat(b);
        String bPlusa = b.concat(a);
        return Integer.parseInt(aPlusb) >= Integer.parseInt(bPlusa);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(myLargestNumber(a));
    }

    @Override
    public int compare(String o1, String o2) {
        String aPlusb = o1.concat(o2);
        String bPlusa = o2.concat(o1);
        return Integer.parseInt(aPlusb) - Integer.parseInt(bPlusa);
    }
}

