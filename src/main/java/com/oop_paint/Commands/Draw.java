package com.oop_paint.Commands;

import com.oop_paint.Interfaces.Command;
import com.oop_paint.Interfaces.Shape;

public class Draw implements Command {
    private Shape shape;

    public Draw(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

    @Override
    public void execute() {

    }
}
