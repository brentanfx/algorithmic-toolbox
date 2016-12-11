package Week1;

import java.util.ArrayList;
import java.util.List;

public class MaximumPairProduct {
    private static long maximumPairProduct(List<Integer> numbers) {
        int num = Integer.MIN_VALUE;
        int index1 = -1;
        int index2 = -1;
        //find largest num
        for (int i = 0; i < numbers.size();i++) {
            if (numbers.get(i) > num) {
                num = numbers.get(i);
                index1 = i;
            }
        }
        num = Integer.MIN_VALUE;
        //find second largest num
        for (int i = 0; i < numbers.size();i++) {
            if (i != index1 && numbers.get(i) > num) {
                num = numbers.get(i);
                index2 = i;
            }
        }
        return (long) numbers.get(index1) * (long) numbers.get(index2);
    }

    public static void main(String args[]) {
        List<Integer> numbers = new ArrayList<>();
        int n = (int) (Math.random() * 10) + 2;
        for (int i = 0; i < n; i++) {
            numbers.add((int) (Math.random() * 100));
        }
        System.out.println(numbers);
        System.out.println(maximumPairProduct(numbers));
    }
}
