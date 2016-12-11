package DynamicProgramming;
import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    private static List<Integer> dpSequence(int n) {
        int[] sequence = new int[n + 1];
        List<Integer> result = new ArrayList<>();
        sequence[1] = 0;
        for (int i = 2; i <= n; i++) {
            sequence[i] = Integer.MAX_VALUE;
            int minOperations;
            if (i % 3 == 0) {
                minOperations = sequence[i / 3] + 1;
                if (minOperations < sequence[i]) {
                    sequence[i] = minOperations;
                }
            }
            if (i % 2 == 0) {
                minOperations = sequence[i / 2] + 1;
                if (minOperations < sequence[i]) {
                    sequence[i] = minOperations;
                }
            }
            minOperations = sequence[i - 1] + 1;
            if (minOperations < sequence[i]) {
                sequence[i] = minOperations;
            }
        }

        while (n > 0) {
            result.add(n);
            int minCount = Integer.MAX_VALUE;
            int condition = 0;
            if (n % 3 == 0) {
                minCount = sequence[n / 3];
            }
            if (n % 2 == 0) {
                if (sequence[n/2] < minCount) {
                    minCount = sequence[n/2];
                    condition = 1;
                }
            }
            if (sequence[n-1] < minCount) {
                condition = 2;
            }
            if (condition == 0)
                n /=3;
            if (condition == 1)
                n/=2;
            if (condition == 2)
                n-=1;

        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = dpSequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}