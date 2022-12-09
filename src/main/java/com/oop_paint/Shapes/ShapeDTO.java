package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShapeDTO {
    public String id;
    public int x;
    public int y;
    public int radius;
    public int radiusX;
    public int radiusY;
    public int width;
    public int height;

    public String color;
    public String shapeType;
    public String commandType;
    public String path;
    public Object attributes;

}
