package CSCI1933P1;

public class Circle {
    private final double xPos;
    private final double yPos;
    private final double rad;
    public Circle(double xPos,double yPos,double rad){
        this.xPos=xPos;
        this.yPos=yPos;
        this.rad=rad;
    }

    public double getRad() {
        return rad;
    }

    public double getYPos() {
        return yPos;
    }

    public double getXPos() {
        return xPos;
    }
}
