package com.oop_paint.commands;

import com.oop_paint.database.Database;
import com.oop_paint.shapes.SegmentLine;
import com.oop_paint.shapes.Shape;
import com.oop_paint.shapes.ShapeDTO;

public class Clone implements Command, Cloneable{
    private Shape protoTypicalShape;
    private Shape clonedShape;
    private ShapeDTO data;
    Database database = Database.getInstance();

    public Clone(ShapeDTO data) {
        this.data = data;
        protoTypicalShape = database.getShape(data.id);
        try {
            clonedShape = (Shape) protoTypicalShape.clone();
            clonedShape.setId(this.data.id2);
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void undo() {
        clonedShape.delete();
    }

    @Override
    public void redo() {
        clonedShape.draw();
    }

    @Override
    public void execute() {
        clonedShape.draw();
    }
}
