package com.oop_paint.Shapes;

import java.util.Arrays;

public class Triangle extends Shape{
    private double x2;
    private double y2;
    private double x3;
    private double y3;
    private double []attributes = new double [4];

    public Triangle(ShapeDTO data) {
        super(data);
        this.x2 = data.x2;
        this.y2 = data.y2;
        this.x3 = data.x3;
        this.y3 = data.y3;
    }

    public Triangle() {
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getX2() {
        return this.x2;
    }

    public double getY2() {
        return this.y2;
    }

//    @Override
//    public void setAttributes(ShapeDTO shapeDTO) {
//        this.x2 = shapeDTO.x2;
//        this.y2 = shapeDTO.y2;
//        this.x3 = shapeDTO.x3;
//        this.y3 = shapeDTO.y3;
//    }

//    @Override
//    public Object getAttributes() {
//        this.attributes[0] = this.x2;
//        this.attributes[1] = this.y2;
//        this.attributes[2] = this.x3;
//        this.attributes[3] = this.y3;
//        return attributes;
//    }




    @Override
    public String toString() {
        return "Triangle{" +
                "x2=" + x2 +
                ", y2=" + y2 +
                ", x3=" + x3 +
                ", y3=" + y3 +
                ", attributes=" + Arrays.toString(attributes) +
                '}';
    }
}
