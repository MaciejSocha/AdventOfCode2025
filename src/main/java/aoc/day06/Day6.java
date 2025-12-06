package aoc.day06;

import utils.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day6 {
    public static void main(String[] args) {
        String input = FileReader.read("src/main/resources/06data.txt");

        List<List<Long>> all = getAllNumbersLists(input);
        List<String> symbols = getSymbols(input);

        long finalResult = 0;
        for (int i = 0; i < symbols.size(); i++) {
            String symbol = symbols.get(i);
            long result = 0;
            if (symbol.equals("+")) result = 0;
            if (symbol.equals("*")) result = 1;

            for (int j = 0; j < all.size(); j++) {
                if (symbol.equals("+")) result += all.get(j).get(i);
                if (symbol.equals("*")) result *= all.get(j).get(i);
            }

            finalResult += result;
        }

        System.out.println(finalResult);
    }

    private static List<List<Long>> getAllNumbersLists(String input) {
        Pattern digitsPattern = Pattern.compile("\\d+");
        List<List<Long>> all = new ArrayList<>();

        for (String line : input.lines().toList()) {
            Matcher digitsMatcher = digitsPattern.matcher(line);
            List<Long> numbers = new ArrayList<>();

            while (digitsMatcher.find()) {
                numbers.add(Long.parseLong(digitsMatcher.group()));
            }

            if (!numbers.isEmpty()) all.add(numbers);
        }

        return all;
    }

    private static List<String> getSymbols(String input) {
        List<String> symbols = new ArrayList<>();
        String line = input.lines().reduce((prv, cur) -> cur).orElse("");

        Pattern symbolsPattern = Pattern.compile("[+*]");
        Matcher symbolsMatcher = symbolsPattern.matcher(line);

        while (symbolsMatcher.find()) {
            symbols.add(symbolsMatcher.group());
        }

        return symbols;
    }
}
