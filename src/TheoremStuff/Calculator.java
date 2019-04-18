package TheoremStuff;

public class Calculator {
    private boolean isPossible;

    private double a, b, c;
    private double aAngle, bAngle, cAngle;

    private double surface;

    public Calculator(){
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }
    public boolean setSideSizes(double a, double b, double c){
        this.isPossible = checkPossible(a, b, c);
        if(checkPossible(a, b, c)){
            this.a = a;
            this.b = b;
            this.c = c;
            return this.isPossible;
        }
        return this.isPossible;
    }
    public void setAngleSizes(double aAngle, double bAngle, double cAngle){
        this.aAngle = aAngle;
        this.bAngle = bAngle;
        this.cAngle = cAngle;
    }

    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }

    public double getaAngle() {
        return aAngle;
    }
    public double getbAngle() {
        return bAngle;
    }
    public double getcAngle() {
        return cAngle;
    }

    public double getaHeight(){
        return (2 * getSurface()) / this.a;
    }
    public double getbHeight(){
        return (2 * getSurface()) / this.b;
    }
    public double getcHeight(){
        return (2 * getSurface()) / this.c;
    }
    public double getaMedian(){
        double m = 2 * (b * b) + 2 * (c * c) - (a * a);
        m = Math.sqrt(m);
        m = m/2;
        return m;
    }
    public double getbMedian(){
        double m = 2 * (c * c) + 2 * (a * a) - (b * b);
        m = Math.sqrt(m);
        m = m/2;
        return m;
    }
    public double getcMedian(){
        double m = 2 * (b * b) + 2 * (a * a) - (c * c);
        m = Math.sqrt(m);
        m = m/2;
        return m;
    }

    public double getSurface(){
        double s, surface;

        s = getSemiperimeter();
        surface = s * (s - this.a) * (s - this.b) * (s - this.c);
        surface = Math.sqrt(surface);
        this.surface = surface;
        return surface;
    }
    public double getPerimeter(){
        return this.a + this.b + this.c;
    }
    public double getSemiperimeter(){
        return getPerimeter() / 2;
    }
    public double getInnerRadius(){
        return getSurface() / getSemiperimeter();
    }
    public double getOuterRadius(){
        return (this.a * this.b * this.c) / (4 * getSurface());
    }
    private boolean checkPossible(double a, double b, double c){
        //returns true if the triangle is possible, and sets the size to calculate the triangle
        //a + b > c, where c is the largest side
        double longest = a;

        if(b > longest){
            longest = b;
        }
        if(c > longest){
            longest = c;
        }
        if(a == longest){
            if(b + c <= a){
                return false;
            }
        }else if(b == longest){
            if(a + c <= b){
                return false;
            }
        }else if(c == longest){
            if(a + b <= c){
                return false;
            }
        }
        if(a <= 0 || b <= 0 || c <= 0){
            return false;
        }
        return true;
    }
}