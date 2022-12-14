package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("square")
public class Square extends Shape {
    private double width;
    private double height;
    
    public Square(ShapeDTO data) {
        super(data);
        this.width = data.width;
        this.height = data.height;
    }

    public Square() {}

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
}
