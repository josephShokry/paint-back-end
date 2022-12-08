package com.oop_paint.commands;

import com.oop_paint.database.Database;
import com.oop_paint.shapes.Shape;
import com.oop_paint.shapes.ShapeDTO;
import com.oop_paint.shapes.ShapeFactory;

public class Draw implements Command{
    private Shape shape;
    private ShapeDTO data;

    public Draw(ShapeDTO data) {
        this.data = data;
    }

    @Override
    public void undo() {
        Database database = Database.getInstance();
        shape.delete();
    }

    @Override
    public void redo() {
        shape.draw();
    }

    @Override
    public void execute() {
        ShapeFactory shapeFactory = new ShapeFactory();
        shape = shapeFactory.getShape(data.shapeType);
        //todo add the dto to the factory
        shape.setX(data.x);
        shape.setY(data.y);
        shape.setColor(data.color);
        shape.setId(data.id);
        shape.setAttributes(data);
        shape.draw();
    }
}
