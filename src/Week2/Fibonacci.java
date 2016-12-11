package Week2;

/**
 * Created by Brentan on 11/5/2016.
 */
public class Fibonacci {
    private static int fibonacci(int n) {
        if (n <= 1)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }
}
