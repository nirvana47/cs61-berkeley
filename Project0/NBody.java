public class NBody {

    /**
     * Reads the radius of the universe and returns that value
     * 
     * @param fileName the file in which this value is stored
     * @return
     */
    public static double readRadius(String fileName) {
        In fName = new In(fileName);
        int numOfPlanets = fName.readInt();
        double radiusUniverse = fName.readDouble();

        return radiusUniverse;
    }

    /**
     * Acquires data about planets, i.e. for initializing an object of class 'Body',
     * which would be the planet.
     * 
     * @param fileName the text file location where these parameters are stored
     * @return array object of class NBody with the necessary details about the
     *         planet bodies
     */
    public static Body[] readBodies(String fileName) {
        In fName = new In(fileName);
        int numOfPlanets = fName.readInt();
        double radiusUniverse = fName.readDouble();
        Body[] bodies = new Body[5];
        int counter = 0;

        while (!fName.isEmpty() && counter < bodies.length) {
            double xxPos, yyPos, xxVel, yyVel, mass;
            String imgFileName;

            xxPos = fName.readDouble();
            yyPos = fName.readDouble();
            xxVel = fName.readDouble();
            yyVel = fName.readDouble();
            mass = fName.readDouble();
            imgFileName = fName.readString();

            bodies[counter] = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);

            counter += 1;
        }

        return bodies;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dT = Double.parseDouble(args[1]);
        String fileName = args[2];
        double univRadius = NBody.readRadius(fileName);
        Body[] bodies = NBody.readBodies(fileName);

        // Set scale
        StdDraw.setScale(-1 * univRadius, univRadius);

        // Center Background image
        StdDraw.picture(0, 0, "./images/starfield.jpg");

        // Draw all the planets
        int count = 0;
        while (count < 5) {
            bodies[count].draw();
            count += 1;
        }

        // To draw off canvas
        StdDraw.enableDoubleBuffering();

        // Variables to increment counter as well as to calculate net X Force and net Y
        // Force on set of bodies
        double time = 0;
        double[] xForces = new double[5];
        double[] yForces = new double[5];

        while (time <= T) {
            for (count = 0; count < 5; count += 1) {
                xForces[count] = bodies[count].calcNetForceExertedByX(bodies);
                yForces[count] = bodies[count].calcNetForceExertedByY(bodies);
            }

            StdDraw.picture(0, 0, "./images/starfield.jpg");

            for (count = 0; count < 5; count += 1) {
                bodies[count].update(dT, xForces[count], yForces[count]);
                bodies[count].draw();
            }

            StdDraw.show();
            StdDraw.pause(10);

            time += dT;
        }

        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", univRadius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", bodies[i].xxPos, bodies[i].yyPos,
                    bodies[i].xxVel, bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }
    }
}