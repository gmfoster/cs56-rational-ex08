/** A class to represent a rational number
    with a numerator and denominator

    @author P. Conrad for CS56 F16

    */

public class Rational {

    private int num;
    private int denom;

    /** 
	greatest common divisor of a and b
	@param a first number
	@param b second number
	@return gcd of a and b
    */
    public static int gcd(int a, int b) {
	if (a==0)
	    return b;
	else if (b==0)
	    return a;
	else
	    return gcd(b%a, a);
    }
    
    public Rational() {
	this.num = 1;
	this.denom = 1;
    }

    public Rational(int num, int denom) {
	if (denom== 0) {
	    throw new IllegalArgumentException("denominator may not be zero");
	}
	this.num = num;
	this.denom = denom;
	if (num != 0) {
	    int gcd = Rational.gcd(num,denom);
	    this.num /= gcd;
	    this.denom /= gcd;
	}
    }

    public String toString() {
	if (denom == 1 || num == 0)
	    return "" + num;
	return num + "/" + denom;
    }

    public int getNumerator() { return this.num; }
    public int getDenominator() { return this.denom; }

    public Rational times(Rational r) {
	return new Rational(this.num * r.num,
			    this.denom * r.denom);
    }

    public static Rational product(Rational a, Rational b) {
	return new Rational(a.num * b.num,
			    a.denom * b.denom);
    }

    
    /** 
	For testing getters.  
	@param args unused
     */

    public static void main (String [] args) {
	Rational r = new Rational(5,7);
	System.out.println("r.getNumerator()=" + r.getNumerator());
	System.out.println("r.getDenominator()=" + r.getDenominator());
    }

    public static int lcm(int a, int b) {
	return ((Math.abs(a * b)) / gcd(a,b));
    }
    
    public Rational plus(Rational r) {
	int commonDenom = lcm(this.denom, r.denom);
	int num1 = this.num * (commonDenom/this.denom);
	int num2 = r.num * (commonDenom/r.denom);
	int sum = num1 + num2;
        return new Rational(sum, commonDenom);
    }
    
    public static Rational sum(Rational a, Rational b) { 
	int commonDenom = lcm(a.denom, b.denom);
	int num1 = a.num * (commonDenom/a.denom);
	int num2 = b.num * (commonDenom/b.denom);
	return new Rational(num1 + num2, commonDenom);
	
    }

    public Rational minus(Rational r) {
	Rational m = new Rational(-1,1);
	return sum(this, product(m,r));
    }
	    
    public static Rational difference(Rational a, Rational b) { 
	Rational m = new Rational(-1,1);
	return sum(a, product(m,b));
    }
	    
    public Rational reciprocalOf() { //how to write test for expected error 
	if (this.num == 0) {
	    throw new ArithmeticException("Numerator may not be 0");
	}
	Rational temp = new Rational(this.denom, this.num);
	return temp;
    }
    
    public Rational dividedBy(Rational r) { 
    	return product(this, r.reciprocalOf());
    }

    public static Rational quotient(Rational a, Rational b) { //write tests
	return product(a, b.reciprocalOf());
    }

    

    
}
