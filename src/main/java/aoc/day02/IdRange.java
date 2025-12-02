package aoc.day02;

public class IdRange {
    private String start;
    private String end;

    public IdRange(String id) {
        start = id.trim().split("-")[0];
        end = id.trim().split("-")[1];
    }

    //returns 0 if ID is valid
    public long validateIds() {
        long result = 0;

        for (long i = Long.parseLong(start); i <= Long.parseLong(end); i++) {
            result += checkIdMultipleTimes(i);
        }

        return result;
    }

    private long checkId(long numericId) {
        long result = 0;
        String id = String.valueOf(numericId);

        if (id.length() % 2 != 0) return result;

        if (id.substring(0, id.length() / 2).equals(id.substring(id.length() / 2))) result = numericId;

        return result;
    }

    private long checkIdMultipleTimes(long numericId) {
        long result = 0;
        String id = String.valueOf(numericId);

        String t = id + id;
        String ss = t.substring(1, t.length()-1);
        if (ss.contains(id)) result += numericId;

        return result;
    }
}
