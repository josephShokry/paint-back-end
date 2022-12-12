package com.oop_paint.Commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.oop_paint.Database.Database;
import com.oop_paint.Shapes.Shape;
import com.oop_paint.Shapes.ShapeDTO;

@JsonTypeName("Resize")
public class Resize extends Command {
    private Shape shape;
    private double oldScaleX;
    private double oldScaleY;
    private double oldStrokeWidth;
    private double oldRotation;
    public Resize(@JsonProperty("Data") ShapeDTO data) {
        this.data = data;
    }

    @Override
    public void undo() {
        shape.setScaleX(this.oldScaleX);
        oldScaleX = data.scaleX;
        data.scaleX = shape.getScaleX();

        shape.setScaleY(this.oldScaleY);
        oldScaleY = data.scaleY;
        data.scaleY = shape.getScaleY();

        shape.setStrokeWidth(this.oldStrokeWidth);
        oldStrokeWidth = data.strokeWidth;
        data.strokeWidth = shape.getStrokeWidth();

        shape.setRotation(this.oldRotation);
        oldRotation = data.rotation;
        data.rotation = shape.getRotation();
    }
    @Override
    public void redo() {
        shape.setScaleX(oldScaleX);
        oldScaleX = data.scaleX;
        data.scaleX = shape.getScaleX();

        shape.setScaleY(oldScaleY);
        oldScaleY = data.scaleY;
        data.scaleY = shape.getScaleY();

        shape.setStrokeWidth(oldStrokeWidth);
        oldStrokeWidth = data.strokeWidth;
        data.strokeWidth = shape.getStrokeWidth();

        shape.setRotation(oldRotation);
        oldRotation = data.rotation;
        data.rotation = shape.getRotation();

    }
    @Override
    public void execute() {
        Database database = Database.getInstance();
        shape = database.getShape(data.id);
        oldScaleX = shape.getScaleX();
        oldScaleY = shape.getScaleY();
        oldRotation = shape.getRotation();
        oldStrokeWidth = shape.getStrokeWidth();

        shape.setScaleX(data.scaleX);
        shape.setScaleY(data.scaleY);
        shape.setRotation(data.rotation);
        shape.setStrokeWidth(data.strokeWidth);

    }

    //getter and setters
    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public double getOldScaleX() {
        return oldScaleX;
    }

    public void setOldScaleX(double oldScaleX) {
        this.oldScaleX = oldScaleX;
    }

    public double getOldScaleY() {
        return oldScaleY;
    }

    public void setOldScaleY(double oldScaleY) {
        this.oldScaleY = oldScaleY;
    }

    public double getStrokeWidth() {
        return oldStrokeWidth;
    }

    public void setStrokeWidth(double strokeWidth) {
        this.oldStrokeWidth = strokeWidth;
    }
}
