package aoc.day02;

import utils.FileReader;

import java.util.ArrayList;
import java.util.List;

public class Day2 {
    public static void main(String[] args) {
        String input = FileReader.read("src/main/resources/02data.txt");
        List<IdRange> idRanges = new ArrayList<>();

        for (String record : input.split(",")) {
            idRanges.add(new IdRange(record));
        }

        long invalidSum = 0;
        for (IdRange range : idRanges) {
            invalidSum += range.validateIds();
        }

        System.out.println(invalidSum);
    }
}
