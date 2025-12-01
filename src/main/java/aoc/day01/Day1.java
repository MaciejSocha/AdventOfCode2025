package aoc.day01;

import utils.FileReader;

public class Day1 {
    public static void main(String[] args) {
        String input = FileReader.read("src/main/resources/01data.txt");
        int position = 50;
        int zeroCount = 0;

        for (String line : input.split("\\R")) {
            char direction = line.charAt(0);
            int distance = Integer.parseInt(line.split(String.valueOf(direction))[1]);

            //full circles
            int fullCirclesCount = distance / 100;
            zeroCount += fullCirclesCount;
            distance -= fullCirclesCount * 100;

            if (direction == 'L') {
                if (position - distance < 0) {
                    distance -= position;
                    if (position != 0) zeroCount++;
                    position = 100 - distance;
                } else if (position - distance == 0) {
                    position -= distance;
                    zeroCount++;
                }
                else position -= distance;
            }

            if (direction == 'R') {
                if (position + distance > 100) {
                    distance -= 100 - position;
                    if (position != 0) zeroCount++;
                    position = distance;
                } else if (position + distance == 100) {
                    zeroCount++;
                    position = 0;
                }
                else position += distance;
            }
        }
        System.out.println(zeroCount);
    }
}
