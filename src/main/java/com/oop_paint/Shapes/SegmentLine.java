package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Arrays;

@JsonTypeName("segmentline")
public class SegmentLine extends Shape{

    private double []points;
    private boolean closed;

    public SegmentLine(ShapeDTO data) {
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
//    }
//
//
//    @Override
//    public Object getAttributes() {
//        this.attributes[0] = this.x2;
//        this.attributes[1] = this.y2;
//        return attributes;
//    }


    @Override
    public String toString() {
        return "SegmentLine{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
