package aoc.day08;

public class Point {
    private int x;
    private int y;
    private int z;
    private boolean connected;

    public Point(String x, String y, String z) {
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
        this.z = Integer.parseInt(z);
        connected = false;
    }

    public double getDistanceToPoint(Point second) {
        return Math.sqrt(Math.pow((x - second.getX()), 2) + Math.pow((y - second.getY()), 2) + Math.pow((z - second.getZ()), 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public boolean isConnected() {
        return connected;
    }
}
