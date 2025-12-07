package aoc.day07;

class DataReader {
    static char[][] getDataIntoMatrix(String input) {
        String[] lines = input.split("\\R");
        char[][] tab = new char[lines.length][];

        for (int i = 0; i < lines.length; i++)
            tab[i] = lines[i].toCharArray();

        return tab;
    }
}
