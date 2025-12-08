package aoc.day08;

import utils.FileReader;

import java.util.ArrayList;
import java.util.List;

public class Day8 {
    public static void main(String[] args) {
        String input = FileReader.read("src/main/resources/08data.txt");
        List<Point> points = new ArrayList<>();
        input.lines().forEach(s -> {
            points.add(new Point(s.split(",")[0], s.split(",")[1], s.split(",")[2]));
        });

        int numberOfPoints = points.size();

        PointsPair pair = getClosestPoint(points);
        System.out.println(pair);
    }

    private static PointsPair getClosestPoint(List<Point> points) {
        double minDist = Double.MAX_VALUE;
        PointsPair pair = null;
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                double dist = points.get(i).getDistanceToPoint(points.get(j));
                if (dist < minDist) {
                    minDist = dist;
                    pair = new PointsPair(points.get(i), points.get(j), dist);
                }
            }
        }
        return pair;
    }
}
