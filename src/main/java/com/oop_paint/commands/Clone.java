package com.oop_paint.Commands;

import com.oop_paint.Database.Database;
import com.oop_paint.Shapes.SegmentLine;
import com.oop_paint.Shapes.Shape;
import com.oop_paint.Shapes.ShapeDTO;




public class Clone extends Command{
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
