package com.oop_paint.Commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.oop_paint.Database.Database;
import com.oop_paint.Shapes.Shape;
import com.oop_paint.Shapes.ShapeDTO;

@JsonTypeName("Recolor")
public class Recolor extends Command{
    private Shape shape;
    private String oldColor;

    public Recolor(@JsonProperty("Data")ShapeDTO data) {
        this.data = data;
        Database database = Database.getInstance();
        this.shape = database.getShape(data.id);
    }

    @Override
    public void undo() {
        shape.setFill(oldColor);
        oldColor = data.fill;
        data.fill = shape.getFill();
    }

    @Override
    public void redo() {
        shape.setFill(oldColor);
        oldColor = data.fill;
        data.fill = shape.getFill();
    }

    @Override
    public void execute() {
        Database database = Database.getInstance();
        shape = database.getShape(data.id);
        oldColor = shape.getFill();
        shape.setFill(data.fill);
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
