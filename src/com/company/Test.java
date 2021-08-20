package com.company;

public class Test {

    void gcdtest() {
        Rational r1 = new Rational(2,3);
        assert(r1.numer==2 && r1.denom==3);

        Rational r2 = new Rational(2,10);
        assert(r2.numer==1 && r2.denom==5);
    }

    void plusRationalTest(){
        Rational rationalOne=new Rational(1,3);
        Rational rationalOther=new Rational(2,5);

        assert(rationalOne.plus(rationalOther).equals(new Rational(11,15)));
    }

    void plusLongTest(){
        Rational rationalOne=new Rational(4,7);
        long other=3;

        assert(rationalOne.plus(other).equals(new Rational(25,7)));
    }


    void minusRationalTest(){
        Rational rationalOne=new Rational(5,9);
        Rational rationalOther=new Rational(1,2);

        assert(rationalOne.minus(rationalOther).equals(new Rational(1,18)));
    }

    void minusLongTest(){
        Rational rationalOne=new Rational(17,5);
        long other=2;

        assert(rationalOne.minus(other).equals(new Rational(7,5)));
    }

    void multiplyRationalTest(){
        Rational rationalOne=new Rational(3,4);
        Rational rationalOther=new Rational(4,8);

        assert(rationalOne.multiply(rationalOther).equals(new Rational(3,8)));
    }

    void multiplyLongTest(){
        Rational rationalOne=new Rational(6,13);
        long other=13;

        assert(rationalOne.multiply(other).equals(new Rational(6,1)));
    }

    void devideRationalTest(){
        Rational rationalOne=new Rational(3,4);
        Rational rationalOther=new Rational(4,8);

        assert(rationalOne.divide(rationalOther).equals(new Rational(3,2)));
    }

    void devideLongTest(){
        Rational rationalOne=new Rational(30,7);
        long other=5;

        assert(rationalOne.divide(other).equals(new Rational(6,7)));
    }

    public static void main(String[] args) {
        Test testSuite=new Test();
        testSuite.gcdtest();

        testSuite.plusRationalTest();
        testSuite.plusLongTest();

        testSuite.minusRationalTest();
        testSuite.minusLongTest();

        testSuite.multiplyRationalTest();
        testSuite.multiplyLongTest();

        testSuite.devideRationalTest();
        testSuite.devideLongTest();
    }


}
