package Week2;

import java.util.ArrayList;
import java.util.List;

public class FibList {
    private static long fibonacci(int n) {
        if (n <= 1)
            return 1;
        List<Long> fibList = new ArrayList<Long>();
        fibList.add(0L);
        fibList.add(1L);
        for (int i = 2; i <= n; i++) {
            fibList.add(fibList.get(i - 1) + fibList.get(i - 2));
        }
        return fibList.get(n);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(239));
    }
}
