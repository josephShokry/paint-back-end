package com.oop_paint.Commands;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.oop_paint.Database.Database;
import com.oop_paint.Shapes.Shape;
import com.oop_paint.Shapes.ShapeDTO;

@JsonTypeName("Resize")
public class Resize implements Command{
    private Shape shape;
    private ShapeDTO data;
    private String shapeType;
    private int oldRadiusX;
    private int oldRadiusY;
    private int oldRadius;
    private int oldWidth;
    private int oldHeight;
    private int temporary;
    private int []attributes;

    public Resize(@JsonProperty("Data")ShapeDTO data) {
        this.data = data;
    }


    @Override
    public void undo() {
        if(shapeType.equalsIgnoreCase("circle")){
            this.temporary = this.oldRadius;
            this.oldRadius = this.data.radius;
            this.data.radius = this.temporary;
        }
        else if (shapeType.equalsIgnoreCase("square") || shapeType.equalsIgnoreCase("rectangle")){
            this.temporary = this.oldWidth;
            this.oldWidth = this.data.width;
            this.data.width = this.temporary;

            this.temporary = this.oldHeight;
            this.oldHeight = this.data.height;
            this.data.height = this.temporary;
        }
        else if(shapeType.equalsIgnoreCase("ellipse")){
            this.temporary = this.oldRadiusX;
            this.oldRadiusX = this.data.radiusX;
            this.data.radiusX = this.temporary;

            this.temporary = this.oldRadiusY;
            this.oldRadiusY = this.data.radiusY;
            this.data.radiusY = this.temporary;
        }
        this.shape.setAttributes(this.data);
    }

    @Override
    public void redo() {
        if(shapeType.equalsIgnoreCase("circle")){
            this.data.radius = this.oldRadius;
        }
        else if (shapeType.equalsIgnoreCase("square") || shapeType.equalsIgnoreCase("rectangle")){
            this.data.width = this.oldWidth;
            this.data.height = this.oldHeight;
        }
        else if(shapeType.equalsIgnoreCase("ellipse")){
            this.data.radiusX = this.oldRadiusX;
            this.data.radiusY = this.oldRadiusY;
        }
        this.shape.setAttributes(this.data);
    }

    @Override
    public void execute() {
        Database database = Database.getInstance();
        shape = database.getShape(data.id);
        shapeType = data.shapeType;
        if(shapeType.equalsIgnoreCase("circle")){
            this.oldRadius = (int) shape.getAttributes();
            shape.setAttributes(this.data);
        }
        else if (shapeType.equalsIgnoreCase("square") || shapeType.equalsIgnoreCase("rectangle")){
            attributes = new int[2];
            attributes = (int[]) shape.getAttributes();
            this.oldWidth  = this.attributes[0];
            this.oldHeight = this.attributes[1];
            shape.setAttributes(this.data);
        }
        else if(shapeType.equalsIgnoreCase("ellipse")){
            attributes = new int[2];
            attributes = (int[]) shape.getAttributes();
            this.oldRadiusX = this.attributes[0];
            this.oldRadiusY = this.attributes[1];
            shape.setAttributes(this.data);
        }
    }
/////getter and setter for the saver

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

    public String getShapeType() {
        return shapeType;
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }

    public int getOldRadiusX() {
        return oldRadiusX;
    }

    public void setOldRadiusX(int oldRadiusX) {
        this.oldRadiusX = oldRadiusX;
    }

    public int getOldRadiusY() {
        return oldRadiusY;
    }

    public void setOldRadiusY(int oldRadiusY) {
        this.oldRadiusY = oldRadiusY;
    }

    public int getOldRadius() {
        return oldRadius;
    }

    public void setOldRadius(int oldRadius) {
        this.oldRadius = oldRadius;
    }

    public int getOldWidth() {
        return oldWidth;
    }

    public void setOldWidth(int oldWidth) {
        this.oldWidth = oldWidth;
    }

    public int getOldHeight() {
        return oldHeight;
    }

    public void setOldHeight(int oldHeight) {
        this.oldHeight = oldHeight;
    }

    public int getTemporary() {
        return temporary;
    }

    public void setTemporary(int temporary) {
        this.temporary = temporary;
    }

    public int[] getAttributes() {
        return attributes;
    }

    public void setAttributes(int[] attributes) {
        this.attributes = attributes;
    }
}
