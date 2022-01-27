package nl.sogyo.javaopdrachten.FractionalCalculations;

public class Fraction {
    private final int numerator;
    private final int denominator;

    public Fraction(int numeratorInput, int denominatorInput){
        numerator = numeratorInput;
        denominator = denominatorInput;
    }

    double toDecimalNotation(){
        return (double) this.numerator / this.denominator;
    }

    String tostring(){
        return this.numerator + "/" + this.denominator;
    }

    Fraction add(int numberToAdd){
        int newNumerator = this.numerator + this.denominator*numberToAdd;
        Fraction addedFraction = new Fraction(newNumerator, this.denominator);
        return addedFraction;
    }

    Fraction add(Fraction fractionToAdd){
        int newDenominator = this.denominator * fractionToAdd.denominator;
        int newNumerator = this.numerator * fractionToAdd.denominator + fractionToAdd.numerator * this.denominator;
        int simplification = simplifyFraction(newNumerator, newDenominator);
        Fraction addedFraction = new Fraction(newNumerator/simplification, newDenominator/simplification);
        return addedFraction;
    }

    Fraction subtract(int numberToSubtract){
        int newNumerator = this.numerator - this.denominator*numberToSubtract;
        Fraction subtractedFraction = new Fraction(newNumerator, this.denominator);
        return subtractedFraction;
    }

    Fraction subtract(Fraction fractionToSubtract){
        int newDenominator = this.denominator * fractionToSubtract.denominator;
        int newNumerator = this.numerator * fractionToSubtract.denominator - fractionToSubtract.numerator * this.denominator;
        int simplification = simplifyFraction(newNumerator, newDenominator);
        Fraction subtractedFraction = new Fraction(newNumerator/simplification, newDenominator/simplification);
        return subtractedFraction;
    }

    Fraction multiply(int numberToMultiply){
        int newNumerator = this.numerator * numberToMultiply;
        int simplification = simplifyFraction(newNumerator, this.denominator);
        Fraction multipliedFraction = new Fraction(newNumerator/simplification, this.denominator/simplification);
        return multipliedFraction;
    }

    Fraction multiply(Fraction fractionToMultiply){
        int newDenominator = this.denominator * fractionToMultiply.denominator;
        int newNumerator = this.numerator * fractionToMultiply.numerator;
        int simplification = simplifyFraction(newNumerator, newDenominator);
        Fraction multipliedFraction = new Fraction(newNumerator/simplification, newDenominator/simplification);
        return multipliedFraction;
    }

    Fraction divide(int numberToDivide){
        int newNumerator = this.numerator;
        int newDenominator = this.denominator;
        if(this.numerator % numberToDivide == 0){
            newNumerator = this.numerator / numberToDivide;
        } else {
            newDenominator = this.denominator * numberToDivide;
        }
        int simplification = simplifyFraction(newNumerator, newDenominator);
        Fraction dividedFraction = new Fraction(newNumerator/simplification, newDenominator/simplification);
        return dividedFraction;
    }

    Fraction divide(Fraction fractionToDivide){
        int newDenominator = this.denominator * fractionToDivide.numerator;
        int newNumerator = this.numerator * fractionToDivide.denominator;
        int simplification = simplifyFraction(newNumerator, newDenominator);
        Fraction dividedFraction = new Fraction(newNumerator/simplification, newDenominator/simplification);
        return dividedFraction;
    }

    int simplifyFraction(int num, int den){
        int simplificationFactor = 1;
        for(int div = Math.max(num, den); div>1; div--){
            if(num % div == 0 && den % div == 0){
                simplificationFactor = div;
                break;
            }
        }
        return simplificationFactor;
    }
 }