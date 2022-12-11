package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("ellipse")
public class Ellipse extends Shape{
    private int radiusX;
    private int radiusY;
    private int []attributes = new int [2];



    public Ellipse(int x, int y, String color, int radiusX, int radiusY,  String id) {
        //todo function to set att of the super
        super.setX(x);
        super.setY(y);
        super.setColor(color);
        super.setId(id);
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public Ellipse() {
    }
    @Override
    public void setAttributes(ShapeDTO shapeDTO){
        this.radiusX = shapeDTO.radiusX;
        this.radiusY = shapeDTO.radiusY;
    }

    @Override
    public Object getAttributes() {
        attributes[0] = this.radiusX;
        attributes[1] = this.radiusY;
        return attributes;
    }

    public int getRadiusX() {
        return this.radiusX;
    }

    public int getRadiusY() {
        return this.radiusY;
    }

    public void setRadiusX(int radiusX) {
        this.radiusX = radiusX;
    }

    public void setRadiusY(int radiusY) {
        this.radiusY = radiusY;
    }
    //TODO add the logic to the command move
    public void move(int x, int y){
        super.setX(x);
        super.setY(y);
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "radiusX=" + radiusX +
                ", radiusY=" + radiusY +
                '}';
    }
}
