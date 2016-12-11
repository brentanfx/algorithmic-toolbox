package Week2;

import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        List<Integer> list = getPissanoPeriod((int) m);
        return list.get((int) (n % list.size()));
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
        long n = scanner.nextLong();
        //long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, 10));
    }
}

