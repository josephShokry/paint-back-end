package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("ellipse")
public class Ellipse extends Shape{
    private double radiusX;
    private double radiusY;
    private double []attributes = new double [2];

    public Ellipse(ShapeDTO data) {
        super(data);
        this.radiusX = data.radiusX;
        this.radiusY = data.radiusY;
    }

    public Ellipse() {
    }
    //    @Override
//    public void setAttributes(ShapeDTO shapeDTO){
//        this.radiusX = shapeDTO.radiusX;
//        this.radiusY = shapeDTO.radiusY;
//    }
//
//    @Override
//    public Object getAttributes() {
//        attributes[0] = this.radiusX;
//        attributes[1] = this.radiusY;
//        return attributes;
//    }

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


    @Override
    public String toString() {
        return "Ellipse{" +
                "radiusX=" + radiusX +
                ", radiusY=" + radiusY +
                '}';
    }
}
