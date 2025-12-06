package aoc.day06;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataReader {
    public static List<List<Long>> getAllNumbersListsLongs(String input) {
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

    public static List<String> getSymbols(String input) {
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
