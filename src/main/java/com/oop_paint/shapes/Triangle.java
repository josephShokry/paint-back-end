package com.oop_paint.Shapes;

import java.util.Arrays;

public class Triangle extends Shape{
    private int x2;
    private int y2;
    private int x3;
    private int y3;
    private int []attributes = new int [4];

    public Triangle(int x, int y, String color, String id, int x2, int y2, int x3, int y3) {
        super.setX(x);
        super.setY(y);
        super.setColor(color);
        super.setId(id);
        this.x2 = x2;
        this.y2 = y2;
    }

    public Triangle() {
    }

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getX2() {
        return this.x2;
    }

    public int getY2() {
        return this.y2;
    }

    @Override
    public void setAttributes(ShapeDTO shapeDTO) {
        this.x2 = shapeDTO.x2;
        this.y2 = shapeDTO.y2;
        this.x3 = shapeDTO.x3;
        this.y3 = shapeDTO.y3;
    }

    @Override
    public ShapeDTO fillData(ShapeDTO shapeDTO) {
        return null;
    }

    @Override
    public Object getAttributes() {
        this.attributes[0] = this.x2;
        this.attributes[1] = this.y2;
        this.attributes[2] = this.x3;
        this.attributes[3] = this.y3;
        return attributes;
    }




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
