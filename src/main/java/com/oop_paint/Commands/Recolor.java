package com.oop_paint.commands;

import com.oop_paint.database.Database;
import com.oop_paint.shapes.Shape;
import com.oop_paint.shapes.ShapeDTO;

public class Recolor implements Command{
    private Shape shape;
    private ShapeDTO data;
    private String oldColor;

    public Recolor(ShapeDTO data) {
        this.data = data;
        Database database = Database.getInstance();
        shape = database.getShape(data.id);
    }

    @Override
    public void undo() {
        shape.setColor(oldColor);
    }

    @Override
    public void redo() {
        shape.setColor(data.color);
    }

    @Override
    public void execute() {
        oldColor = shape.getColor();
        shape.setColor(data.color);
    }
}
