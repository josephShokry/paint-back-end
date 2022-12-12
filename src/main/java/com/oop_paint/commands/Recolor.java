package com.oop_paint.commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.oop_paint.database.Database;
import com.oop_paint.shapes.Shape;
import com.oop_paint.shapes.ShapeDTO;

@JsonTypeName("Recolor")
public class Recolor extends Command{
    private Shape shape;
    private String oldColor;

    public Recolor(@JsonProperty("Data")ShapeDTO data) {
        this.data = data;
    }

    @Override
    public void undo() {
        shape.setColor(oldColor);
        oldColor = data.fill;
        data.fill = shape.getColor();
    }

    @Override
    public void redo() {
        shape.setColor(oldColor);
        oldColor = data.fill;
        data.fill = shape.getColor();
    }

    @Override
    public void execute() {
        Database database = Database.getInstance();
        shape = database.getShape(data.id);
        oldColor = shape.getColor();
        shape.setColor(data.fill);
    }

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

    public String getOldColor() {
        return oldColor;
    }

    public void setOldColor(String oldColor) {
        this.oldColor = oldColor;
    }
}
