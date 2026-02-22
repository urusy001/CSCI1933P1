package CSCI1933P1;
import java.awt.Color;

public class Circle {
    private double xPos;
    private double yPos;
    private double radius;
    private Color color;
    public Circle(double xPos,double yPos,double rad){
        this.xPos=xPos;
        this.yPos=yPos;
        this.radius=rad;
    }

    public double getRadius() {
        return radius;
    }

    public double getYPos() {
        return yPos;
    }

    public double getXPos() {
        return xPos;
    }

    public double calculatePerimeter(){
        return Math.PI*2*radius;
    }
    public double calculateArea(){
        return Math.pow(this.radius, 2)*Math.PI;
    }
    public void setColor(Color color){
        this.color=color;
    }
    public void setPos(double x,double y){
        this.xPos=x;
        this.yPos=y;
    }
    public void setRadius(double radius){
        this.radius=radius;
    }

    public Color getColor() {
        return color;
    }
}
