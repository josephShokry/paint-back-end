package com.oop_paint.commands;

import com.oop_paint.database.Database;
import com.oop_paint.shapes.Shape;
import com.oop_paint.shapes.ShapeDTO;

public class Delete implements Command {

    private Shape shape;
    private ShapeDTO data;

    public Delete(ShapeDTO data) {
        this.data = data;
        Database database = Database.getInstance();
        shape = database.getShape(data.id);
    }

    @Override
    public void undo() {
        shape.draw();
    }

    @Override
    public void redo() {
        shape.delete();
    }

    @Override
    public void execute() {
        shape.delete();
    }
}
