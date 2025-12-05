package aoc.day05;

import utils.FileReader;

import java.util.ArrayList;
import java.util.List;

public class Day5 {
    public static void main(String[] args) {
        String input = FileReader.read("src/main/resources/05data.txt");
        List<Range> rangesList = new ArrayList<>();
        List<Long> ids = new ArrayList<>();

        for (String line : input.lines().toList()) {
            if (line.contains("-")) rangesList.add(new Range(line));
            else if (!line.isEmpty()) ids.add(Long.parseLong(line));
        }
        System.out.println("readed");

        int sum = 0;
        for (long id : ids) {
            for (Range range : rangesList) {
                if (range.checkIfInRange(id)) {
                    sum++;
                    break;
                }
            }
        }

        System.out.println(sum);
    }
}
