import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TestBody {
    public static void main(String[] args) {
        Body sun = new Body(1.0, 1.0, 3.0, 9.0, 50.0, "sun.gif");
        Body earth = new Body(5.2, -11.7, 3.0, 4.5, 95.0, "earth.gif");

        DecimalFormat numFormat = new DecimalFormat("0.###E0");

        System.out.println(
                "The pair-wise force between sun and the earth is " + numFormat.format(sun.calcForceExertedBy(earth)));

        System.out.println("The pair-wise force between sun and the earth is " + sun.calcForceExertedBy(earth));
    }
}