package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
public class ShapeDTO {
    public double []points;
    public double x; //for all shapes
    public double y; //for all shapes
    public double radius; //for circle
    public double radiusX; //for ellipse
    public double radiusY; //for ellipse
    public double width; //for sharp shapes
    public double height; //for sharp shapes
    public double scaleX;
    public double scaleY;
    public double rotation;
    public double strokeWidth;

    // for all shapes
    public String id;
    public String id2; // for clone
    public String fill;
    public String stroke;
    public String commandType;
    public String path;
    public String className;
    public String saveData;
    
    public Object stage;

    public boolean closed;

}
