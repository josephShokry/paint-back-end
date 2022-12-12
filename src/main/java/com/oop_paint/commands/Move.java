package com.oop_paint.commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.oop_paint.database.Database;
import com.oop_paint.shapes.Shape;
import com.oop_paint.shapes.ShapeDTO;

@JsonTypeName("Move")
public class Move extends Command{

    private Shape shape;
    private int oldX;
    private int oldY;

    public Move(@JsonProperty("Data")ShapeDTO data) {
        this.data = data;
    }

    @Override
    public void undo() {
        shape.setX(this.oldX);
        shape.setY(this.oldY);
        oldX = data.x;
        oldY = data.y;
        data.x = shape.getX();
        data.y = shape.getY();
    }

    @Override
    public void redo() {
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
}
