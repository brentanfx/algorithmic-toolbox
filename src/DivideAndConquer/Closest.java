package DivideAndConquer;

import java.io.*;
import java.util.*;

public class Closest {

    static class Point implements Comparable<Point>{
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return o.y == y ? Long.signum(x - o.x) : Long.signum(y - o.y);
        }
    }

    static double minimalDistance(int[] x, int y[]) {
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            points.add(new Point(x[i], y[i]));
        }
        Collections.sort(points);

        return findMinimum(points, 0, points.size() - 1);
    }

    public static Comparator<Point> PointComparator    = new Comparator<Point>() {

        public int compare(Point a, Point b) {

            return b.x == a.x ? Long.signum(a.y - b.y) : Long.signum(a.x - b.x);
        }

    };


    private static double findMinimum(ArrayList<Point> points, int start, int end) {
        if (start >= end)
            return Double.POSITIVE_INFINITY;
        int mid = (start + end) / 2;
        double d1 = findMinimum(points, start, mid);
        double d2 = findMinimum(points, mid + 1, end);
        double d = Math.min(d1, d2);
        List<Point> strip = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            double dist = Math.abs(dist(points.get(i), points.get(mid)));
            if (dist < d) {
                strip.add(points.get(i));
            }
        }
        Collections.sort(strip, PointComparator );
        double newMin = Double.POSITIVE_INFINITY;
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(i).x - strip.get(j).x) < d; j++) {
                if (dist(strip.get(i), strip.get(j)) < d) {
                    newMin = dist(strip.get(i), strip.get(j));
                }
            }
        }
        return Math.min(newMin, d);
    }

    private static double dist(Point a, Point b) {
        return  Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
    }

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
        }
        System.out.println(minimalDistance(x, y));
        writer.close();
    }

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");


    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }
}
