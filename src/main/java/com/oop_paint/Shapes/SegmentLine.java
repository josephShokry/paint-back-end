package com.oop_paint.shapes;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("segmentline")
public class SegmentLine extends Shape{

    @Override
    public void setAttributes(ShapeDTO shapeDTO) {

    }

    @Override
    public Object getAttributes() {
        return null;
    }
}
