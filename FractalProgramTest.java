package CSCI1933P1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class FractalProgramTest {
    public static void main(String[] args) {
        int passed = 0;
        int failed = 0;

        try {
            testTriangleFractalOption();
            passed++;
            System.out.println("PASS: testTriangleFractalOption");
        } catch (AssertionError e) {
            failed++;
            System.out.println("FAIL: testTriangleFractalOption - " + e.getMessage());
        }

        try {
            testRectangleFractalOption();
            passed++;
            System.out.println("PASS: testRectangleFractalOption");
        } catch (AssertionError e) {
            failed++;
            System.out.println("FAIL: testRectangleFractalOption - " + e.getMessage());
        }

        try {
            testCircleFractalOption();
            passed++;
            System.out.println("PASS: testCircleFractalOption");
        } catch (AssertionError e) {
            failed++;
            System.out.println("FAIL: testCircleFractalOption - " + e.getMessage());
        }

        System.out.println("Tests run: " + (passed + failed) + ", passed: " + passed + ", failed: " + failed);
        if (failed > 0) {
            System.exit(1);
        }
    }

    private static void testTriangleFractalOption() {
        FakeFractalDrawer fake = new FakeFractalDrawer(123.5);
        String output = runProgram("triangle\n", fake);

        assertTrue(fake.wasCalled, "FractalDrawer should be called for valid triangle input");
        assertEquals("triangle", fake.lastType, "Program should pass the selected shape to drawFractal");
        assertContains(output, "Choose a fractal shape", "Program should print shape choices");
        assertContains(output, "Total area: 123.5", "Program should print the returned total area");
    }

    private static void testRectangleFractalOption() {
        FakeFractalDrawer fake = new FakeFractalDrawer(9.75);
        String output = runProgram("rectangle\n", fake);

        assertTrue(fake.wasCalled, "FractalDrawer should be called for rectangle input");
        assertEquals("rectangle", fake.lastType, "Program should pass rectangle to drawFractal");
        assertContains(output, "Total area: 9.75", "Program should print rectangle fractal area");
    }

    private static void testCircleFractalOption() {
        FakeFractalDrawer fake = new FakeFractalDrawer(42.0);
        String output = runProgram("circle\n", fake);

        assertTrue(fake.wasCalled, "FractalDrawer should be called for circle input");
        assertEquals("circle", fake.lastType, "Program should pass circle to drawFractal");
        assertContains(output, "Total area: 42.0", "Program should print circle fractal area");
    }

    private static String runProgram(String input, FakeFractalDrawer fake) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(bytes);
        Scanner scanner = new Scanner(input);

        FractalProgram.run(scanner, out, fake);
        out.flush();
        return bytes.toString();
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void assertEquals(String expected, String actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + " (expected: " + expected + ", actual: " + actual + ")");
        }
    }

    private static void assertContains(String output, String expectedSubstring, String message) {
        if (!output.contains(expectedSubstring)) {
            throw new AssertionError(message + " (missing: " + expectedSubstring + ")");
        }
    }

    private static class FakeFractalDrawer extends FractalDrawer {
        private final double result;
        private boolean wasCalled;
        private String lastType;

        FakeFractalDrawer(double result) {
            this.result = result;
        }

        @Override
        public double drawFractal(String type) {
            wasCalled = true;
            lastType = type;
            return result;
        }
    }
}
