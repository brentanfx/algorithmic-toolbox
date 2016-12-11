package GreedyAlgorithm;

import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        Arrays.sort(segments);
        int[] points = new int[segments.length];
        int pointIndex = 0;
        int index = 0;
        while (index < segments.length) {
            points[pointIndex] = segments[index].end;
            while (index < segments.length && segments[index].start <= points[pointIndex]) {
                index++;
            }
            pointIndex++;
        }
        return points;
    }

    private static class Segment implements Comparable<Segment>{
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Segment o) {
            return this.end - o.end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        //System.out.println(points.length);
        for (int point : points) {
            if (point == 0)
                break;
            System.out.print(point + " ");
        }
    }
}


