package aoc.day03;

import utils.FileReader;

import java.util.Arrays;

public class Day3 {
    private static int NUMBERS_TO_CHOOSE = 12;

    public static void main(String[] args) {
        String input = FileReader.read("src/main/resources/03data.txt");

        //part one
        System.out.println(partOne(input));

        //part two
        long joltage = 0;

        for (String bank : input.lines().toList()) {
            String[] rets = new String[NUMBERS_TO_CHOOSE];
            rets = recursion(bank, NUMBERS_TO_CHOOSE, rets);
            joltage += Long.parseLong(String.join("", Arrays.stream(rets).toList()));
        }
        System.out.println(joltage);
    }

    public static String[] recursion(String bank, int numbersLeft, String[] numbers) {
        int currentNumber = NUMBERS_TO_CHOOSE - numbersLeft;
        if (currentNumber >= NUMBERS_TO_CHOOSE) return numbers;
        for (int i = 9; i > 0; i--) {
            String number = String.valueOf(i);
            if (bank.indexOf(number) < (bank.length() - numbersLeft + 1) && bank.contains(number)) {
                numbers[currentNumber] = number;
                bank = bank.substring(bank.indexOf(number) + 1);
                break;
            }
        }
        return recursion(bank, numbersLeft - 1, numbers);
    }

    public static int partOne(String input) {
        int sum = 0;

        for (String bank : input.lines().toList()) {
            String numberOne = "";
            String numberTwo = "";

            for (int i = 9; i > 0; i--) {
                String firstNumber = String.valueOf(i);

                if (bank.indexOf(firstNumber) != bank.length() - 1 && bank.contains(firstNumber)) { //last digit && not found
                    numberOne = firstNumber;

                    for (int j = 9; j > 0; j--) {
                        String secondNumber = String.valueOf(j);

                        String subString = bank.substring(bank.indexOf(firstNumber) + 1);
                        if (subString.contains(secondNumber)) {
                            numberTwo = secondNumber;
                            break;
                        }
                    }
                    if (!numberTwo.isEmpty()) break;
                }
            }
            sum += Integer.parseInt(numberOne + numberTwo);
        }
        return sum;
    }
}

