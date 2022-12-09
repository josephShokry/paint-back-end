package com.oop_paint.Commands;

import com.oop_paint.Database.Database;
import com.oop_paint.Shapes.Shape;
import com.oop_paint.Shapes.ShapeDTO;

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
