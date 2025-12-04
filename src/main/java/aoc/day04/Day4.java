package aoc.day04;

import utils.FileReader;

import java.util.ArrayList;
import java.util.List;

public class Day4 {
    public static void main(String[] args) {
        String input = FileReader.read("src/main/resources/04data.txt");

        int rows = (int) input.lines().count();
        int columns = input.lines().findFirst().get().length();
        Element[][] map = getElementsArray(input);

        int number = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++) {
                if (map[i][j].isElementRoll()) {
                    List<Pair> allNeighbors = getAllNeighbors(map[i][j]);
                    List<Pair> allExistingNeighbors = checkNeighborsExists(allNeighbors, rows, columns);
                    int numberOfRollNeighbors = calculateRollNeighbors(allExistingNeighbors, map);
                    if (numberOfRollNeighbors < 4) number++;
                }
            }
        System.out.println(number);
    }

    private static int calculateRollNeighbors(List<Pair> neighbors, Element[][] map) {
        int sum = 0;
        for (Pair p : neighbors) {
            if (map[p.getRow()][p.getColumn()].isElementRoll()) sum++;
        }
        return sum;
    }

    private static List<Pair> checkNeighborsExists(List<Pair> allNeighbors, int rows, int columns) {
        List<Pair> existing = new ArrayList<>();
        for (Pair p : allNeighbors) {
            if (p.getRow() >= 0 && p.getRow() < rows && p.getColumn() >= 0 && p.getColumn() < columns) existing.add(p);
        }
        return existing;
    }

    private static List<Pair> getAllNeighbors(Element element) {
        List<Pair> nbs = new ArrayList<>();

        nbs.add(new Pair(element.getRowPosition() - 1, element.getColumnPosition() - 1));
        nbs.add(new Pair(element.getRowPosition() - 1, element.getColumnPosition()));
        nbs.add(new Pair(element.getRowPosition() - 1, element.getColumnPosition() + 1));
        nbs.add(new Pair(element.getRowPosition(), element.getColumnPosition() - 1));
        nbs.add(new Pair(element.getRowPosition(), element.getColumnPosition() + 1));
        nbs.add(new Pair(element.getRowPosition() + 1, element.getColumnPosition() - 1));
        nbs.add(new Pair(element.getRowPosition() + 1, element.getColumnPosition()));
        nbs.add(new Pair(element.getRowPosition() + 1, element.getColumnPosition() + 1));

        return nbs;
    }

    private static Element[][] getElementsArray(String input) {
        int rows = (int) input.lines().count();
        int columns = input.lines().findFirst().get().length();

        Element[][] map = new Element[rows][columns];

        int i = 0;
        for (String line : input.lines().toList()) {
            int j = 0;
            for (char character : line.toCharArray()) {
                map[i][j] = new Element(character, i, j);
                j++;
            }
            i++;
        }

        return map;
    }
}
