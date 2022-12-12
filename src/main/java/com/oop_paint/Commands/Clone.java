package com.oop_paint.Commands;

import com.oop_paint.Database.Database;
import com.oop_paint.Shapes.Shape;
import com.oop_paint.Shapes.ShapeDTO;




public class Clone extends Command implements Cloneable{
    private Shape protoTypicalShape;
    private Shape clonedShape;

    public Clone(ShapeDTO data) {
        this.data = data;
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
        Database database = Database.getInstance();
        protoTypicalShape = database.getShape(data.id);
        try {
            clonedShape = (Shape) protoTypicalShape.clone();
            clonedShape.setId(null);
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        clonedShape.draw();
        this.data = clonedShape.toDTO();
        this.data.commandType = "clone";
        this.data.className = clonedShape.getClass().getSimpleName();
    }
}