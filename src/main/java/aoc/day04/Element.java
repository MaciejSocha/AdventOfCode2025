package aoc.day04;

public class Element {
    private final boolean isRoll;
    private final int rowPosition;
    private final int columnPosition;
    private boolean isInFirstRow;
    private boolean isInLastRow;
    private boolean isInFirstColumn;
    private boolean isInLastColumn;

    public Element(char character, int rowPosition, int columnPosition) {
        isRoll = character == '@';
        this.rowPosition = rowPosition;
        this.columnPosition = columnPosition;
    }

    public boolean isElementRoll() {
        return isRoll;
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public int getColumnPosition() {
        return columnPosition;
    }

    public void setInFirstRow(boolean inFirstRow) {
        isInFirstRow = inFirstRow;
    }

    public void setInLastRow(boolean inLastRow) {
        isInLastRow = inLastRow;
    }

    public void setInFirstColumn(boolean inFirstColumn) {
        isInFirstColumn = inFirstColumn;
    }

    public void setInLastColumn(boolean inLastColumn) {
        isInLastColumn = inLastColumn;
    }

    public boolean isInFirstRow() {
        return isInFirstRow;
    }

    public boolean isInLastRow() {
        return isInLastRow;
    }

    public boolean isInFirstColumn() {
        return isInFirstColumn;
    }

    public boolean isInLastColumn() {
        return isInLastColumn;
    }

    @Override
    public String toString() {
        return "Element{" +
                "isRoll=" + isRoll +
                ", rowPosition=" + rowPosition +
                ", columnPosition=" + columnPosition +
                ", isInFirstRow=" + isInFirstRow +
                ", isInLastRow=" + isInLastRow +
                ", isInFirstColumn=" + isInFirstColumn +
                ", isInLastColumn=" + isInLastColumn +
                '}';
    }
}
