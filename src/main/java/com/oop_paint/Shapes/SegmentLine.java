package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("segmentline")
public class SegmentLine extends Shape{

    private int x2;
    private int y2;
    private int []attributes = new int [2];

    public SegmentLine(int x, int y, String color, String id, int x2, int y2) {
        super.setX(x);
        super.setY(y);
        super.setColor(color);
        super.setId(id);
        this.x2 = x2;
        this.y2 = y2;
    }

    public SegmentLine() {
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
    }

    @Override
    public Object getAttributes() {
        this.attributes[0] = this.x2;
        this.attributes[1] = this.y2;
        return attributes;
    }

    public void move(int x, int y){
        super.setX(x);
        super.setY(y);
    }

    @Override
    public String toString() {
        return "SegmentLine{" +
                "x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }
}
