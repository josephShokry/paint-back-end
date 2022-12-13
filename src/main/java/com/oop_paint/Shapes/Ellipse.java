package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("ellipse")
public class Ellipse extends Shape{
    private double radiusX;
    private double radiusY;
    private double []attributes = new double [2];



    public Ellipse(double x, double y, String fill, double radiusX, double radiusY,  String id) {
        //todo function to set att of the super
        super.setX(x);
        super.setY(y);
        super.setFill(fill);
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

    public double getRadiusX() {
        return this.radiusX;
    }

    public double getRadiusY() {
        return this.radiusY;
    }

    public void setRadiusX(double radiusX) {
        this.radiusX = radiusX;
    }

    public void setRadiusY(double radiusY) {
        this.radiusY = radiusY;
    }
    //TODO add the logic to the command move
    public void move(double x, double y){
        super.setX(x);
        super.setY(y);
    }

    public ShapeDTO fillData(ShapeDTO shapeDTO){
        return null;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "radiusX=" + radiusX +
                ", radiusY=" + radiusY +
                '}';
    }
}
