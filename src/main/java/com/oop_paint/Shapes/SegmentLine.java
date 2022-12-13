package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("segmentline")
public class SegmentLine extends Shape{

    private double x2;
    private double y2;
    private double []attributes = new double [2];

    public SegmentLine(ShapeDTO data) {
        super(data);
        this.x2 = data.x2;
        this.y2 = data.y2;
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


    @Override
    public String toString() {
        return "SegmentLine{" +
                "x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }
}
