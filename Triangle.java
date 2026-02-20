package CSCI1933P1;

public class Triangle {
    private final double xPos;
    private final double yPos;
    private final double width;
    private final double height;

    public Triangle(double xPos, double yPos, double width, double height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
    };

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getXPos() {
        return yPos;
    }

    public double getYPos() {
        return xPos;
    }
}
