public class NBody {

    public static double readRadius(String fileName) {
        In fName = new In(fileName);
        int numOfPlanets = fName.readInt();
        double radiusUniverse = fName.readDouble();

        return radiusUniverse;
    }

    public static Body[] readBodies(String fileName) {
        In fName = new In(fileName);
        int numOfPlanets = fName.readInt();
        double radiusUniverse = fName.readDouble();
        Body[] bodies = new Body[5];
        int counter = 0;
        while (!fName.isEmpty() && counter < bodies.length) {
            bodies[counter].xxPos = fName.readDouble();
            bodies[counter].yyPos = fName.readDouble();
            bodies[counter].xxVel = fName.readDouble();
            bodies[counter].yyVel = fName.readDouble();
            bodies[counter].mass = fName.readDouble();
            bodies[counter].imgFileName = fName.readString();
            counter += 1;
        }

        return bodies;
    }
}