public class Body {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

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
     * @param b object of class Body
     * @return
     */
    public double calcDistance(Body b) {

        double dX = this.xxPos - b.xxPos;
        double dY = this.yyPos - b.yyPos;
        double r = Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));

        return r;
    }

}