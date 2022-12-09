package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.oop_paint.Database.Database;

//@JsonIgnoreProperties(ignoreUnknown = true, value = {"attributes"})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY, visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Square.class, name = "square"),
        @JsonSubTypes.Type(value = Circle.class, name = "circle"),
        @JsonSubTypes.Type(value = Ellipse.class, name = "ellipse"),
        @JsonSubTypes.Type(value = Rectangle.class, name = "rectangle"),
        @JsonSubTypes.Type(value = SegmentLine.class, name = "segmentline")
})
@JsonIgnoreProperties(value = "attributes",ignoreUnknown = true)
public abstract class Shape {
    private int x;
    private int y;
    private String id;
    private String color;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract void setAttributes(ShapeDTO shapeDTO);

    public abstract Object getAttributes();

    public void draw(){
        Database database = Database.getInstance();
        database.addShape(this);
    }
    public void delete(){
        Database database = Database.getInstance();
        database.deleteShape(id);
    }

    @Override
    public String toString() {
        return "Shape{" +
                "x=" + x +
                ", y=" + y +
                ", color='" + color + '\'' +
                '}';
    }
}
