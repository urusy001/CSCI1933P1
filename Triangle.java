package CSCI1933P1;

import java.awt.Color;

public class Triangle {
    private double xPos;
    private double yPos;
    private double width;
    private double height;
    private Color color;

    public Triangle(double xPos, double yPos, double width, double height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getXPos() {
        return xPos;
    }

    public double getYPos() {
        return yPos;
    }

    public double calculatePerimeter() {
        return this.width + 2 * Math.sqrt(Math.pow(this.width/2, 2) + Math.pow(this.height, 2));
    }

    public double calculateArea() {
        return this.width * this.height / 2;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setPos(double x, double y) {
        this.xPos = x;
        this.yPos = y;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

}
