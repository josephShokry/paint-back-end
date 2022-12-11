package com.oop_paint.shapes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShapeDTO {
    public int x; //for all shapes
    public int y; //for all shapes
    public int x2; //for lines
    public int y2; //for lines
    public int radius; //for circle
    public int radiusX; //for ellipse
    public int radiusY; //for ellipse
    public int width; //for sharp shapes
    public int height; //for sharp shapes

    // for all shapes
    public String id;
    public String id2; // for clone
    public String color;
    public String shapeType;
    public String commandType;
    public String path;
    public Object attributes;

}
