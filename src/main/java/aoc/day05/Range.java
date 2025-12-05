package aoc.day05;

public class Range {
    private String start;
    private String end;
    private long startNumber;
    private long endNumber;

    public Range(String id) {
        start = id.trim().split("-")[0];
        end = id.trim().split("-")[1];

        startNumber = Long.parseLong(start);
        endNumber = Long.parseLong(end);
    }

    public boolean checkIfInRange(Long number) {
        if (number >= startNumber && number <= endNumber) return true;
        return false;
    }
}
