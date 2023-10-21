package edu.hw2.task1;

public final record Negate(Expr operand) implements Expr {
    @Override
    public double evaluate() {
        return -operand.evaluate();
    }
}
