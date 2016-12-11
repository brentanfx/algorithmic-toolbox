package DivideAndConquer;

import java.util.*;

public class PointsAndSegments {

    private static class Point implements Comparable<Point> {
        private int point;
        private int type;
        private int index;

        public Point(int point, int type) {
            this(point, type, -1);
        }

        public Point(int point, int type, int index) {
            this.point = point;
            this.type = type;
            this.index = index;
        }

        @Override
        public int compareTo(Point o) {
            if (this.point - o.point != 0) {
                return this.point - o.point;
            }
            else {
                return this.type - o.type;
            }
        }
    }

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        List<Point> segPoints = new ArrayList<Point>();
        for (int i = 0; i < starts.length; i++) {
            segPoints.add(new Point(starts[i], 0));
            segPoints.add(new Point(ends[i], 2));
        }

        for (int i = 0; i < points.length; i++) {
            segPoints.add(new Point(points[i], 1, i));
        }

        Collections.sort(segPoints);
        int count = 0;
        for (Point point  : segPoints) {
            if (point.type == 0) {
                count++;
            }
            else if (point.type == 2) {
                count--;
            }
            else {
                cnt[point.index] = count;
            }
        }

        //write your code here
        return cnt;
    }


    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

