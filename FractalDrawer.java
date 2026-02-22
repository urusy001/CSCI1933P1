package CSCI1933P1;
import java.awt.Color;

public class FractalDrawer {
    private double totalArea = 0;  // member variable for tracking the total area

    public FractalDrawer() {}  // contructor


    // drawFractal creates a new Canvas object and dispatches to the requested fractal.
    public double drawFractal(String type) {
        totalArea = 0;
        Canvas canvas = new Canvas();
        int level = 7;
        if (type == null) return totalArea;

        if (type.equalsIgnoreCase("triangle")) drawTriangleFractal(180, 180, 310, 650, colorFor(level, 0), canvas, level);
        else if (type.equalsIgnoreCase("circle")) drawCircleFractal(90, 400, 400, colorFor(level, 0), canvas, level);
        else if (type.equalsIgnoreCase("rectangle")) drawRectangleFractal(160, 100, 320, 350, colorFor(level, 0), canvas, level);


        return totalArea;
    }


    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        if (level <= 0) return;

        Triangle current = new Triangle(x, y, width, height);
        current.setColor(c);
        can.drawShape(current);
        totalArea += current.calculateArea();

        if (level == 1) return;

        double childW = width / 2.0;
        double childH = height / 2.0;

        double leftX = x - childW / 2.0;
        double leftY = y;

        double rightX = x + width - childW / 2.0;
        double rightY = y;

        double topX = x + (width / 2.0) - (childW / 2.0);
        double topY = y - height;

        drawTriangleFractal(childW, childH, leftX, leftY, colorFor(level - 1, 1), can, level - 1);
        drawTriangleFractal(childW, childH, rightX, rightY, colorFor(level - 1, 2), can, level - 1);
        drawTriangleFractal(childW, childH, topX, topY, colorFor(level - 1, 3), can, level - 1);
    }

    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        if (level <= 0 || radius <= 0) return;

        Circle current = new Circle(x, y, radius);
        current.setColor(c);
        can.drawShape(current);
        totalArea += current.calculateArea();

        if (level == 1) return;
        double childRadius = radius / 2.0;

        drawCircleFractal(childRadius, x - radius, y, colorFor(level - 1, 1), can, level - 1);
        drawCircleFractal(childRadius, x + radius, y, colorFor(level - 1, 2), can, level - 1);
        drawCircleFractal(childRadius, x, y - radius, colorFor(level - 1, 3), can, level - 1);
        drawCircleFractal(childRadius, x, y + radius, colorFor(level - 1, 4), can, level - 1);
    }


    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        if (level <= 0 || width <= 0 || height <= 0) return;

        Rectangle current = new Rectangle(x, y, width, height);
        current.setColor(c);
        can.drawShape(current);
        totalArea += current.calculateArea();

        if (level == 1) return;
        double childW = width / 2.0;
        double childH = height / 2.0;

        double topX = x + (width - childW) / 2.0;
        double topY = y - childH;

        double bottomX = x + (width - childW) / 2.0;
        double bottomY = y + height;

        double leftX = x - childW;
        double leftY = y + (height - childH) / 2.0;

        double rightX = x + width;
        double rightY = y + (height - childH) / 2.0;

        drawRectangleFractal(childW, childH, topX, topY, colorFor(level - 1, 1), can, level - 1);
        drawRectangleFractal(childW, childH, bottomX, bottomY, colorFor(level - 1, 2), can, level - 1);
        drawRectangleFractal(childW, childH, leftX, leftY, colorFor(level - 1, 3), can, level - 1);
        drawRectangleFractal(childW, childH, rightX, rightY, colorFor(level - 1, 4), can, level - 1);
    }

    private Color colorFor(int level, int branch) {
        float hue = (float) ((level * 0.17 + branch * 0.11) % 1.0);
        return Color.getHSBColor(hue, 0.75f, 0.95f);
    }
}
