package com.oop_paint.shapes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShapeDTO {
    public String id;
    public int x;
    public int y;
    public int radius;
    public int width;
    public int height;

    public String color;
    public String shapeType;
    public String commandType;
    public String path;

}
