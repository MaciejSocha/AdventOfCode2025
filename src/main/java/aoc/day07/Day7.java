package aoc.day07;

import utils.FileReader;

import java.util.ArrayList;
import java.util.List;

public class Day7 {
    public static void main(String[] args) {
        String input = FileReader.read("src/main/resources/07data.txt");
        char[][] tab = DataReader.getDataIntoMatrix(input);

        List<Integer> positions = new ArrayList<>();
        List<Boolean> flags = new ArrayList<>();
        for (int i = 0; i < tab[0].length; i++) if (tab[0][i] == 'S') positions.add(i);
        flags.add(true);

        int splits = 0;
        for (int i = 1; i < tab.length; i++) {
            for (int j = 0; j < positions.size(); j++) {
                int position = positions.get(j);

                if (flags.get(j)) {
                    if (tab[i][position] == '.') //go down
                        System.out.println("Going down");

                    else if (tab[i][position] == '^') {//splitting
                        splits++;

                        if (position > 0) {
                            if (positions.contains(position - 1)) {
                                flags.set(positions.indexOf(position - 1), true);
                            } else {
                                positions.add(position - 1);
                                flags.add(true);
                            }
                        }

                        if (position < tab[i].length) {
                            if (positions.contains(position + 1)) {
                                flags.set(positions.indexOf(position + 1), true);
                            } else {
                                positions.add(position + 1);
                                flags.add(true);
                            }
                        }

                        flags.set(j, !flags.get(j));
                    }
                }
            }
        }
        System.out.println(splits);
    }
}
