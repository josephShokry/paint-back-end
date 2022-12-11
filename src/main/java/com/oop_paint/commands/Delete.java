package com.oop_paint.commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oop_paint.database.Database;
import com.oop_paint.shapes.Shape;
import com.oop_paint.shapes.ShapeDTO;

public class Delete extends Command {

    private Shape shape;

    public Delete(@JsonProperty("Data")ShapeDTO data) {
        super.data = data;
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
        Database database = Database.getInstance();
        shape = database.getShape(data.id);
        shape.delete();
    }
    //getter and setters for saver

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public ShapeDTO getData() {
        return data;
    }

    public void setData(ShapeDTO data) {
        this.data = data;
    }
}
