package aoc.day05;

import utils.FileReader;

import java.util.ArrayList;
import java.util.Comparator;
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

        rangesList.sort(Comparator.comparingLong(Range::getStartNumber));

        long start = rangesList.get(0).getStartNumber();
        long end = rangesList.get(0).getEndNumber();
        long numbers = 0;

        for (int i = 0; i < rangesList.size(); i++) {
            if (i == rangesList.size() - 1) {
                numbers += end - start + 1;
                break;
            }

            if ((end >= rangesList.get(i + 1).getStartNumber())) {//overlapped
                if ((rangesList.get(i + 1).getEndNumber() >= end))
                    end = rangesList.get(i + 1).getEndNumber();
                else continue;
            } else {
                numbers += end - start + 1;
                start = rangesList.get(i + 1).getStartNumber();
                end = rangesList.get(i + 1).getEndNumber();
            }
        }

        System.out.println(numbers);
    }
}
