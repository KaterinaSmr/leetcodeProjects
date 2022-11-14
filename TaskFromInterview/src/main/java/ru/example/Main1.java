package ru.example;

/*
2) Дан набор точек на двумерной плоскости (координаты x, y). Нужно написать метод, который определит существует ли
 вертикальная ось симметрии для этих точек.
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {
        Point a1 = new Point(3,5);
        Point a2 = new Point(7,5);
        Point b1 = new Point(-1,2);
        Point b2 = new Point(11, 2);
        Point[] points = new Point[]{a2, b1, b2, a1};
        Arrays.sort(points, Comparator.comparingInt(o -> o.x));
        System.out.println(Arrays.toString(points));

        double axis = Arrays.stream(points).mapToInt(p-> p.x).average().getAsDouble();
        System.out.println(axis);

        Set<Point> pointsSet = Set.of(points);
        for (int i = 0; i < points.length/2 + 1; i++) {
            if (!findTwin(points[i], axis, pointsSet)){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");

    }

    static boolean findTwin (Point p, double axis, Set<Point> points){

        Point requiredPoint = new Point((int) (2 * axis - p.x), p.y);
        boolean contains = points.contains(requiredPoint);
        System.out.println(p + " - " + requiredPoint);
        if (p.x == axis) return true;
        return contains;
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "[" + x + ";" + y + "]";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
