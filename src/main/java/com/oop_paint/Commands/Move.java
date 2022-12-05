package com.oop_paint.Commands;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oop_paint.Interfaces.Command;
import com.oop_paint.Interfaces.Shape;

public class Move implements Command {
    @JsonIgnore
    public Shape shape;
    public int newX;
    public int newY;
    public Move() {

    }

    public Move(Shape shape, int newX, int newY) {
        this.shape = shape;
        this.newX = newX;
        this.newY = newY;
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

    public int getNewX() {
        return newX;
    }

    public void setNewX(int newX) {
        this.newX = newX;
    }

    public int getNewY() {
        return newY;
    }

    public void setNewY(int newY) {
        this.newY = newY;
    }
}
