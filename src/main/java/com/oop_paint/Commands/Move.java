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

    public Move() {

    }

    public Move(Shape shape, int x, int y) {
        this.shape = shape;
        this.X = x;
        this.Y = y;
    }

    @Override
    public void undo() {
        this.shape.move(previousX, previousY);
    }

    @Override
    public void redo() {
        this.shape.move(X, Y);
    }


    @Override
    public void execute() {
        this.previousX = shape.getx();
        this.previousY = shape.gety();
        this.shape.move(X,Y);
    }

    @Override
    public String toString() {
        return "Move{" +
                "shape=" + shape +
                ", X=" + X +
                ", Y=" + Y +
                ", previousX=" + previousX +
                ", previousY=" + previousY +
                '}';
    }
}
