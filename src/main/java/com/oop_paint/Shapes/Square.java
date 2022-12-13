package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("square")
public class Square extends Shape {
    private double width;
    private double height;
    private double []attributes = new double [2];

    public Square(ShapeDTO data) {
        super(data);
        this.width = data.width;
        this.height = data.height;
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

    @Override
    public String toString() {
        return "square{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
