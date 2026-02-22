package CSCI1933P1;

import java.io.PrintStream;
import java.util.Scanner;

public class FractalProgram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        run(scan, System.out, new FractalDrawer());
    }

    static void run(Scanner scan, PrintStream out, FractalDrawer fractalDrawer) {
        out.println("Choose a fractal shape: triangle, rectangle, or circle");

        if (!scan.hasNextLine()) {
            out.println("No shape provided.");
            return;
        }

        String shape = scan.nextLine().trim();
        if (shape.isEmpty()) {
            out.println("No shape provided.");
            return;
        }

        if (!shape.equalsIgnoreCase("triangle")
                && !shape.equalsIgnoreCase("rectangle")
                && !shape.equalsIgnoreCase("circle")) {
            out.println("Invalid shape. Please choose triangle, rectangle, or circle.");
            return;
        }

        double totalArea = fractalDrawer.drawFractal(shape);
        out.println("Total area: " + totalArea);
    }
}
