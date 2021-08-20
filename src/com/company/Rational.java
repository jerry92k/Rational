package com.company;

import java.util.Objects;

final class Rational {
    final long numer; // 분자
    final long denom; // 분모

  /* 위 numer, denom을 private로 하고 게터/세터를 만들 수도 있지만, 그렇게 하는게 좋은 설계일까? 어차피 numer,denum은 final인데?
  long getNumer() {
      return numer;
  }
  long getDenom() {
      return denom;
  }
  */

    Rational(final long numer, final long denom) throws IllegalArgumentException {
        if(denom==0L) throw new IllegalArgumentException("분모는 0이 아닌 long이어야 합니다.");
        long gcd = gcd(numer,denom);
        this.numer = numer/gcd;
        this.denom = denom/gcd;
    }

    Rational(final long wholeInteger) {
        this.numer = wholeInteger;
        this.denom = 1;
    }

    // 무식한 유클리드 호제법
    // (a,b) -> (b,a%b) -> ... -> (t,0) => t는 최대공약수
    private long gcd(long a, long b) {
        while(b!=0) {
            long tmp = a; // 임시변수
            a = b;
            b = tmp % b;
        }
        return a;
    }

    // rational + rational
    public Rational plus(Rational other) {
        long commonDenom = denom * other.denom;
        long newNumer = numer*other.denom + denom*other.numer;
        return new Rational(newNumer, commonDenom);

    }
    // rational + long
    public Rational plus(long coefficient) {
        return new Rational((coefficient*denom) + numer, denom);
    }
    // **자바에서는 long.plus(rational)을 정의할 방법이 없음

    // minus, times, divide 등의 다른 메서드 정의 필요

    // Rational - Rational
    public Rational minus(Rational other){
        long commonDenom = denom * other.denom;
        long newNumer = numer*other.denom - denom*other.numer;
        return new Rational(newNumer, commonDenom);
    }

    // Rational - long
    public Rational minus(long coefficient){
        return new Rational(numer - (coefficient*denom), denom);
    }

    // Rational / Rational
    public Rational divide(Rational other){
        long commonDenom = denom * other.numer;
        long newNumer = numer *other.denom;
        return new Rational(newNumer, commonDenom);
    }

    // Rational / long
    public Rational divide(long coefficient){
        return new Rational(numer, denom*coefficient);
    }

    // Rational * Rational
    public Rational multiply(Rational other){
        return new Rational(numer* other.numer , denom* other.denom);
    }

    // Rational * long
    public Rational multiply(long coefficient){
        return new Rational(numer* coefficient , denom);
    }


    // toString을 정의해야 제대로 값을 볼 수 있음!
    @Override
    public String toString() {
        return "Rational{" +
                "numer=" + numer +
                ", denom=" + denom +
                '}';
    }


    // equals와 hashCode도 정의해야 함
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rational rational = (Rational) o;
        return numer == rational.numer && denom == rational.denom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numer, denom);
    }

}