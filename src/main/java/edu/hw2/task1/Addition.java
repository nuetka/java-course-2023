package edu.hw2.task1;

public record Addition(Expr leftOperand, Expr rightOperand) implements Expr {
    @Override
    public double evaluate() {
        return leftOperand.evaluate() + rightOperand.evaluate();
    }
}
