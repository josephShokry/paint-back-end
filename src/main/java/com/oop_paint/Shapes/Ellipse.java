package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("ellipse")
public class Ellipse extends Shape{
    private double radiusX;
    private double radiusY;
    
    public Ellipse(ShapeDTO data) {
        super(data);
        this.radiusX = data.radiusX;
        this.radiusY = data.radiusY;
    }
    
    public Ellipse() {}
    
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
}
