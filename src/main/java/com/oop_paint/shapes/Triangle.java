package com.oop_paint.Shapes;

import java.util.Arrays;

public class Triangle extends Shape{

    private double []points;
    private boolean closed;

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Triangle(ShapeDTO data) {
        super(data);
        this.points = data.points;
        this.closed = data.closed;
    }

    public double[] getPoints() {
        return points;
    }

    public void setPoints(double[] points) {
        this.points = points;
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


    // @Override
    // public String toString() {
    //     return "Triangle{" +
    //             "points=" + Arrays.toString(points) +
    //             '}';
    // }
}
