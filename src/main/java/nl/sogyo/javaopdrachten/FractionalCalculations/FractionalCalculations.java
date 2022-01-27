package nl.sogyo.javaopdrachten.FractionalCalculations;

public class FractionalCalculations {
    public static void main(String[] args) {
       // test cases as described in assignment text
       Fraction oneThird = new Fraction(1, 3);
       Fraction oneSixth = new Fraction(1, 6);
       Fraction fourThirds = new Fraction(4, 3);
       Fraction oneHalf = new Fraction(1,2);
       Fraction threeQuarters = new Fraction(3,4);
       Fraction twoFifths = new Fraction(2,5);
       Fraction oneAndAHalf = new Fraction(3,2);
       Fraction threeTenths = new Fraction(3,10);
       System.out.println(oneThird.toDecimalNotation());
       System.out.println(oneThird.tostring());
       System.out.println(oneThird.add(1).tostring());
       System.out.println(oneThird.add(oneSixth).tostring());
       System.out.println(fourThirds.subtract(1).tostring()); 
       System.out.println(oneHalf.subtract(oneSixth).tostring());
       System.out.println(threeQuarters.multiply(2).tostring());
       System.out.println(threeQuarters.multiply(twoFifths).tostring());
       System.out.println(oneAndAHalf.divide(2).tostring());
       System.out.println(threeTenths.divide(twoFifths).tostring());
    }  
}
   