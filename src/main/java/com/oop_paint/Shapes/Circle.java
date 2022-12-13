package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("circle")
public class Circle extends Shape {
    private double radius;

    public Circle(ShapeDTO data) {
        super(data);
        this.radius = data.radius;
    }

    public Circle() {}

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
