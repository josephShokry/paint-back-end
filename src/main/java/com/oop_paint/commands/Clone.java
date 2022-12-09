package com.oop_paint.commands;

import com.oop_paint.database.Database;
import com.oop_paint.shapes.Shape;
import com.oop_paint.shapes.ShapeDTO;

public class Clone implements Command{

    private Shape shape;
    private ShapeDTO data;

    public Clone(ShapeDTO data) {
        this.data = data;
        Database database = Database.getInstance();
        shape = database.getShape(data.id);
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
