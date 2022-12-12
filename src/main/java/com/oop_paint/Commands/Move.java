package com.oop_paint.Commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.oop_paint.Database.Database;
import com.oop_paint.Shapes.Shape;
import com.oop_paint.Shapes.ShapeDTO;

@JsonTypeName("Move")
public class Move extends Command{

    private Shape shape;
    private double oldX;
    private double oldY;

    public Move(@JsonProperty("Data")ShapeDTO data) {
        this.data = data;
    }

    @Override
    public void undo() {
        Database database = Database.getInstance();
        shape = database.getShape(data.id);
        shape.setX(this.oldX);
        shape.setY(this.oldY);
        oldX = data.x;
        oldY = data.y;
        data.x = shape.getX();
        data.y = shape.getY();
    }

    @Override
    public void redo() {
        Database database = Database.getInstance();
        shape = database.getShape(data.id);
        shape.setX(oldX);
        shape.setY(oldY);
        oldX = data.x;
        oldY = data.y;
        data.x = shape.getX();
        data.y = shape.getY();
    }

    @Override
    public void execute() {
        Database database = Database.getInstance();
        shape = database.getShape(data.id);
        oldX = shape.getX();
        oldY = shape.getY();
        shape.setX(data.x);
        shape.setY(data.y);
    }
//setters and getters
    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public double getOldX() {
        return oldX;
    }

    public void setOldX(double oldX) {
        this.oldX = oldX;
    }

    public double getOldY() {
        return oldY;
    }

    public void setOldY(double oldY) {
        this.oldY = oldY;
    }
}
