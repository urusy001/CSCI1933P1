package CSCI1933P1;
import java.awt.Color;

public class Circle {
    private double xPos;
    private double yPos;
    private double rad;
    private Color color;
    public Circle(double xPos,double yPos,double rad){
        this.xPos=xPos;
        this.yPos=yPos;
        this.rad=rad;
    }

    public double getRadius() {
        return rad;
    }

    public double getYPos() {
        return yPos;
    }

    public double getXPos() {
        return xPos;
    }

    public double calculatePerimeter(){
        return Math.PI*2*rad;
    }
    public double calculateArea(){
        return Math.pow((Math.PI*2),2);
    }
    public void setColor(Color color){
        this.color=color;
    }
    public void setPos(double x,double y){
        this.xPos=x;
        this.yPos=y;
    }
    public void setRadius(double radius){
        this.rad=radius;
    }

    public Color getColor() {
        return color;
    }
}
