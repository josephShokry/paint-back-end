package com.oop_paint.shapes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShapeDTO {

    public int x;
    public int y;
    public int radius;
    public int radiusX;
    public int radiusY;
    public int width;
    public int height;
    public int scaleX;
    public int scaleY;
    public String id;
    public String fill;
    public String commandType;
    public String path;
    public String className;

    public Object stage;
}
