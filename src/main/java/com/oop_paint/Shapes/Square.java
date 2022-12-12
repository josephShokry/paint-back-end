package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("square")
public class Square extends Shape {
    private double width;
    private double height;
    private double []attributes = new double [2];

    public Square(double x, double y, String color, String id, double width, double height) {
        super.setX(x);
        super.setY(y);
        super.setFill(color);
        super.setId(id);
        this.width = width;
        this.height = height;
    }

    public Square() {
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void setAttributes(ShapeDTO shapeDTO) {
        this.width = shapeDTO.width;
        this.height = shapeDTO.height;
    }

    @Override
    public Object getAttributes() {
        this.attributes[0] = this.width;
        this.attributes[1] = this.height;
        return attributes;
    }

    public void move(double x, double y){
        super.setX(x);
        super.setY(y);
    }

    @Override
    public String toString() {
        return "square{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
