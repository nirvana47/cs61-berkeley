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

    /**
     * Unlike the calcForceExertedBy method, which returns the total force, this
     * method describes the force exerted in the X direction
     * 
     * @param b object of class Body which is exerting the force
     * @return Force exerted in X direction
     */
    public double calcForceExertedByX(Body b) {
        double dX = b.xxPos - this.xxPos;
        return (this.calcForceExertedBy(b) * dX) / this.calcDistance(b);
    }

    /**
     * Unlike the calcForceExertedBy method, which returns the total force, this
     * method describes the force exerted in the Y direction
     * 
     * @param b object of class Body which is exerting the force
     * @return Force exerted in Y direction
     */
    public double calcForceExertedByY(Body b) {
        double dY = b.yyPos - this.yyPos;
        return (this.calcForceExertedBy(b) * dY) / this.calcDistance(b);
    }

    /**
     * Takes in an array of Bodys and calculates the net X force exerted by all
     * bodies in that array upon the current Body.
     * 
     * @param bodies array of bodies which are exerting force on THE body
     * @return Net Force in X direction
     */
    public double calcNetForceExertedByX(Body[] bodies) {
        double FxNet = 0.0;
        for (int i = 0; i < bodies.length; i += 1) {
            if (this.equals(bodies[i])) {
                continue;
            }
            FxNet += this.calcForceExertedByX(bodies[i]);
        }
        return FxNet;
    }

    /**
     * Takes in an array of Bodys and calculates the net Y force exerted by all
     * bodies in that array upon the current Body.
     * 
     * @param bodies array of bodies which are exerting force on THE body
     * @return Net Force in Y direction
     */
    public double calcNetForceExertedByY(Body[] bodies) {
        double FyNet = 0.0;
        for (int i = 0; i < bodies.length; i += 1) {
            if (this.equals(bodies[i])) {
                continue;
            }
            FyNet += this.calcForceExertedByY(bodies[i]);
        }
        return FyNet;
    }

}