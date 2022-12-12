package com.oop_paint.Commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oop_paint.Database.Database;
import com.oop_paint.Shapes.Shape;
import com.oop_paint.Shapes.ShapeDTO;

public class Delete extends Command {

    private Shape shape;

    public Delete(@JsonProperty("Data")ShapeDTO data) {
        super.data = data;
    }

    @Override
    public void undo() {
        shape.draw();
        //TODO we have to get the data form the shape to the DTO
        data = shape.toDTO();
        data.className = shape.getClass().getSimpleName();
        data.commandType = "delete";
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
