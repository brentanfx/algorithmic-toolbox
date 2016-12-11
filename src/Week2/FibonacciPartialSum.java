package Week2;

import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        List<Integer> list = getPissanoPeriod((int) m);
        long sum = 0;
        for (Integer aList : list) {
            sum += aList;
        }
        long multiple = n / list.size();
        long remainder = n % list.size();
        int remaining = 0;
        for (int i = 0; i <= remainder; i++) {
            remaining += list.get(i);
        }
        return (multiple * sum ) + remaining;
    }

    private static List<Integer> getPissanoPeriod(int m) {
        List<Integer> fibList = new ArrayList<Integer>();
        fibList.add(0);
        fibList.add(1);
        for (int i = 2; i <= m * 12; i++) {
            fibList.add((fibList.get(i - 1) + fibList.get(i - 2)) % m);
            if (fibList.size() >= 6) {
                List<Integer> list1 = fibList.subList(0, (fibList.size() / 2));
                List<Integer> list2 = fibList.subList(fibList.size()/2, fibList.size());
                if (list1.equals(list2))
                    break;
            }
        }
        return fibList.subList(0, fibList.size() / 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long m = scanner.nextLong();
        long n = scanner.nextLong();
        long time = System.nanoTime();
        System.out.println(getFibonacciHugeNaive(m, 10));
        System.out.println(getFibonacciHugeNaive(n, 10));
        System.out.println((getFibonacciHugeNaive(n, 10) - getFibonacciHugeNaive(m - 1, 10)) % 10);
        long endTime = System.nanoTime();
        System.out.println(endTime - time);
    }
}

