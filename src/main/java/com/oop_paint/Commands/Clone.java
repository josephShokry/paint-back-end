package com.oop_paint.Commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.oop_paint.Database.Database;
import com.oop_paint.Shapes.Shape;
import com.oop_paint.Shapes.ShapeDTO;



@JsonTypeName("Clone")
public class Clone extends Command implements Cloneable{
    private Shape protoTypicalShape;
    private Shape clonedShape;

    public Clone(@JsonProperty("Data")ShapeDTO data) {
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

    public Shape getProtoTypicalShape() {
        return protoTypicalShape;
    }

    public void setProtoTypicalShape(Shape protoTypicalShape) {
        this.protoTypicalShape = protoTypicalShape;
    }

    public Shape getClonedShape() {
        return clonedShape;
    }

    public void setClonedShape(Shape clonedShape) {
        this.clonedShape = clonedShape;
    }
}