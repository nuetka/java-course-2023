package edu.hw2.task1;

public final record Constant(double value) implements Expr {
    @Override
    public double evaluate() {
        return value;
    }
}
