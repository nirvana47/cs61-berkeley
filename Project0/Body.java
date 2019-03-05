public class Body {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double GravConst = 6.67e-11;

    // Constructor #1 to be instantiated with values
    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    // Constructor #2 to be instantiated with an object
    public Body(Body b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    /**
     * Function that calculates the distance between two Bodys. This method will
     * take in a single Body and should return a double equal to the distance
     * between the supplied body and the body that is doing the calculation
     * 
     * @param b the body from which distance needs to be calculated
     * @return the distance between the two bodies
     */
    public double calcDistance(Body b) {

        // distance on X-axis
        double dX = this.xxPos - b.xxPos;
        
        // distance on Y-axis
        double dY = this.yyPos - b.yyPos;
        
        // r-square = square root of dX-square + dY-square
        double r = Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));

        return r;
    }

    /**
     * The method takes in a Body, and returns a double describing the force exerted
     * on this body by the given body.
     * 
     * @param b object of class Body which is exerting the force
     * @return the force being exerted by the body on the other
     */
    public double calcForceExertedBy(Body b) {
        // [G x m1 x m2]/[distance-squared]
        return (GravConst * this.mass * b.mass) / Math.pow(this.calcDistance(b), 2);

    }

}