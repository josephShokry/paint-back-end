package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
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
public abstract class Shape implements Cloneable {
    private int x;
    private int y;
    private int scaleX;
    private int scaleY;
    private String id;
    private String fill;

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

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScaleX() {
        return scaleX;
    }

    public void setScaleX(int scaleX) {
        this.scaleX = scaleX;
    }

    public int getScaleY() {
        return scaleY;
    }

    public void setScaleY(int scaleY) {
        this.scaleY = scaleY;
    }

    public abstract void setAttributes(ShapeDTO shapeDTO);

    public abstract Object getAttributes();

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void draw(){
        Database database = Database.getInstance();
        this.setId(database.addShape(this));
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
                ", fill='" + fill + '\'' +
                '}';
    }
    public ShapeDTO toDTO(){
        ObjectMapper mapper = new JsonMapper();
        String json = null;
        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
            return mapper.readValue(json, ShapeDTO.class);
        } catch (Exception e) {
            return null;
        }
    }
}
