package com.oop_paint.Commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.oop_paint.Database.Database;
import com.oop_paint.Shapes.Shape;
import com.oop_paint.Shapes.ShapeDTO;

@JsonTypeName("Recolor")
//@JsonPropertyOrder({"data","shape","oldColor"})
public class Recolor implements Command{
    private Shape shape;
    private ShapeDTO data;
    private String oldColor;

    public Recolor(@JsonProperty("Data")ShapeDTO data) {
        this.data = data;
        Database database = Database.getInstance();
        this.shape = database.getShape(data.id);
    }

    @Override
    public void undo() {
        shape.setColor(oldColor);
    }

    @Override
    public void redo() {
        shape.setColor(data.color);
    }

    @Override
    public void execute() {
        oldColor = shape.getColor();
        shape.setColor(data.color);
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
