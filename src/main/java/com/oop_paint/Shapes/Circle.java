package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("circle")
public class Circle extends Shape {
    private double radius;

    public Circle(double x, double y, String color, double radius, String id) {
        //todo function to set att of the super
        super.setX(x);
        super.setY(y);
        super.setFill(color);
        super.setId(id);
        this.radius = radius;
    }

    public Circle() {
    }
    @Override
    public void setAttributes(ShapeDTO shapeDTO){
        radius = shapeDTO.radius;
    }

    @Override
    public Double getAttributes() {
        return radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    //TODO add the logic to the command move
    public void move(int x, int y){
        super.setX(x);
        super.setY(y);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
