package edu.hw2.task1;

public final record Exponent(Expr base, int power) implements Expr {
    @Override
    public double evaluate() {
        return Math.pow(base.evaluate(), power);
    }
}
