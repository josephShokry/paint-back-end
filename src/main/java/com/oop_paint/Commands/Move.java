package com.oop_paint.Commands;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oop_paint.Interfaces.Command;
import com.oop_paint.Interfaces.Shape;

public class Move implements Command {
    @JsonIgnore
    private Shape shape;

    private int X;
    private int Y;
    private int previousX;
    private int previousY;

    public int getPreviousX() {
        return previousX;
    }

    public void setPreviousX(int previousX) {
        this.previousX = previousX;
    }

    public int getPreviousY() {
        return previousY;
    }

    public void setPreviousY(int previousY) {
        this.previousY = previousY;
    }

    public Move() {

    }

    public Move(Shape shape, int newX, int newY) {
        this.shape = shape;
        this.X = newX;
        this.Y = newY;
    }

    @Override
    public void undo() {
        System.out.println("undo move command");
    }

    @Override
    public void redo() {
        System.out.println("redo move command");
    }

    @Override
    public void execute() {
        System.out.println("execute move command");
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        this.X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        this.Y = y;
    }
}
