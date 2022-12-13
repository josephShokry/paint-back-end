package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("rectangle")
public class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(ShapeDTO data) {
        super(data);
        this.width = data.width;
        this.height = data.height;
    }
    
    public Rectangle() {
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
    
//    private double []attributes = new double [2];
//    @Override
//    public void setAttributes(ShapeDTO shapeDTO) {
//        this.width = shapeDTO.width;
//        this.height = shapeDTO.height;
//    }
//    @Override
//    public Object getAttributes() {
//        this.attributes[0] = this.width;
//        this.attributes[1] = this.height;
//        return attributes;
//    }

    // @Override
    // public String toString() {
    //     return "Rectangle{" +
    //             "width=" + width +
    //             ", height=" + height +
    //             '}';
    // }
}
