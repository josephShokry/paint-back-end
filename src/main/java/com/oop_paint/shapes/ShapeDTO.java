package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    public int scaleX;
    public int scaleY;

    // for all shapes
    public String id;
    public String id2; // for clone
    public String fill;

    public String commandType;
    public String path;
    public String className;

    public Object stage;
}
