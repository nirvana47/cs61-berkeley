public class NBody {

    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int numOfPlanets = in.readInt();
        double radiusUniverse = in.readDouble();

        return radiusUniverse;
    }

    public static Body[] readBodies(String fileName){
        return Body[];
    }
}