public class HelloNumbers {
    public static void main(String[] args) {
        System.out.println("Hello Numbers!");

        int x = 0;
        int y = 0;
        while (x < 10) {
            System.out.print(y + " ");
            x = x + 1;
            y=y+x;
        }
        System.out.println();
    }
}