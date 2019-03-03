public class Triangle {
    public static void main(String[] args) {
        for (int x = 1; x <= 5; x++) {      //loop to go through 5 lines
            for (int y = 0; y < x; y++) {   //loop to draw the triangle
                System.out.print("*");
            }
            System.out.println();
        }

    }
}