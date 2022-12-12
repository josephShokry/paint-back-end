package com.oop_paint.commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.oop_paint.database.Database;
import com.oop_paint.shapes.Shape;
import com.oop_paint.shapes.ShapeDTO;

@JsonTypeName("Resize")
public class Resize extends Command {
    private Shape shape;
    private int oldScaleX;
    private int oldScaleY;

    public Resize(@JsonProperty("Data") ShapeDTO data) {
        this.data = data;
    }

    @Override
    public void undo() {
        shape.setScaleX(this.oldScaleX);
        shape.setScaleY(this.oldScaleY);
        oldScaleX = data.scaleX;
        oldScaleY = data.scaleY;
        data.scaleX = shape.getScaleX();
        data.scaleY = shape.getScaleY();
    }

    @Override
    public void redo() {
        shape.setScaleX(oldScaleX);
        shape.setScaleY(oldScaleY);
        oldScaleX = data.scaleX;
        oldScaleY = data.scaleY;
        data.scaleX = shape.getScaleX();
        data.scaleY = shape.getScaleY();
    }

    @Override
    public void execute() {
        Database database = Database.getInstance();
        shape = database.getShape(data.id);
        oldScaleX = shape.getScaleX();
        oldScaleY = shape.getScaleY();
        shape.setScaleX(data.scaleX);
        shape.setScaleY(data.scaleY);
    }
}
