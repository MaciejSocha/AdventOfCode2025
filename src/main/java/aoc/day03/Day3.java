package aoc.day03;

import utils.FileReader;

public class Day3 {
    public static void main(String[] args) {
        String input = FileReader.read("src/main/resources/03data.txt");
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
        System.out.println(sum);
    }
}
