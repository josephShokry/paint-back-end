package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("segmentline")
public class SegmentLine extends Shape{

    private double[] points;
    private boolean closed;

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public SegmentLine(ShapeDTO data) {
        super(data);
        this.points = data.points;
        this.closed = data.closed;
    }

    public SegmentLine() {}

    public double[] getPoints() {
        return points;
    }

    public void setPoints(double[] points) {
        this.points = points;
    }
}
