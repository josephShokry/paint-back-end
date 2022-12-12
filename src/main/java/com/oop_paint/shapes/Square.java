package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("square")
public class Square extends Shape {
    private int width;
    private int height;
    private int []attributes = new int [2];

    public Square(int x, int y, String color, String id, int width, int height) {
        super.setX(x);
        super.setY(y);
        super.setColor(color);
        super.setId(id);
        this.width = width;
        this.height = height;
    }

    public Square() {
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setAttributes(ShapeDTO shapeDTO) {
        this.width = shapeDTO.width;
        this.height = shapeDTO.height;
    }

    @Override
    public ShapeDTO fillData(ShapeDTO shapeDTO) {
        return null;
    }

    @Override
    public Object getAttributes() {
        this.attributes[0] = this.width;
        this.attributes[1] = this.height;
        return attributes;
    }

    public void move(int x, int y){
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
