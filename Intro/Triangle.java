public class Triangle {
    public static void drawTriangle(int x) {
        if (x == 0 || x < 0) {
            System.out.println("Invalid entry! 0 or less than zero not allowed.");
        } else {
            for (int counter = 1; counter <= x; counter++) {
                for (int y = 0; y < counter; y++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        drawTriangle(10);

    }
}