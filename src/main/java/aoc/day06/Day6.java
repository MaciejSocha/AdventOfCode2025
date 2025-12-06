package aoc.day06;

import utils.FileReader;

import java.util.ArrayList;
import java.util.List;

public class Day6 {
    public static void main(String[] args) {
        String input = FileReader.read("src/main/resources/06data.txt");

        List<List<Long>> all = DataReader.getAllNumbersListsLongs(input);
        List<String> symbols = DataReader.getSymbols(input);

        //part 1
        long finalResult = 0;
        for (int i = 0; i < symbols.size(); i++) {
            String symbol = symbols.get(i);
            long result = 0;
            if (symbol.equals("+")) result = 0;
            if (symbol.equals("*")) result = 1;

            for (List<Long> longs : all) {
                if (symbol.equals("+")) result += longs.get(i);
                if (symbol.equals("*")) result *= longs.get(i);
            }

            finalResult += result;
        }

        System.out.println(finalResult);

        //part2
        String[] lines = input.split("\\R");
        char[][] tab = new char[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            tab[i] = lines[i].toCharArray();
        }

        List<String> allData = new ArrayList<>();
        long answer = 0;
        for (int i = tab[0].length - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            boolean emptyColumn = true;

            for (int j = 0; j < tab.length; j++) {
                char c = tab[j][i];
                sb.append(c);
                if (c != ' ') emptyColumn = false;
            }

            if (emptyColumn) {
                answer += calculate(allData);
                allData.clear();
            } else {
                String cleaned = sb.toString().strip();
                allData.add(cleaned);
            }

            if (i == 0) {
                answer += calculate(allData);
            }
        }

        System.out.println("---");
        System.out.println(answer);
    }

    private static long calculate(List<String> data) {
        long result = 0;
        boolean flag = false;
        if (data.isEmpty()) return 0;
        if (data.get(data.size() - 1).contains("+")) {
            result = 0;
            data.set(data.size() - 1, data.get(data.size() - 1).split("\\+")[0].trim());
            flag = true;
        } else if (data.get(data.size() - 1).contains("*")) {
            result = 1;
            data.set(data.size() - 1, data.get(data.size() - 1).split("\\*")[0].trim());
            flag = false;
        }

        for (String number : data) {
            if (flag) {
                result += Long.parseLong(number);
            } else {
                result *= Long.parseLong(number);
            }
        }

        return result;
    }
}
