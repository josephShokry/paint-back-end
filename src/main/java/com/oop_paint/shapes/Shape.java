package com.oop_paint.Shapes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.oop_paint.Database.Database;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;

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
    private double x;
    private double y;
    private double scaleX;
    private double scaleY;
    private double rotation;
    private double strokeWidth;
    private String id;
    private String fill;
    private String stroke;

    public Shape(ShapeDTO data) {
        this.x = data.x;
        this.y = data.y;
        this.scaleX = data.scaleX;
        this.scaleY = data.scaleY;
        this.rotation = data.rotation;
        this.strokeWidth = data.strokeWidth;
        this.fill = data.fill;
        this.stroke = data.stroke;
    }
    public Shape(){

    }

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
    
    //getters and setters
    public double getX() {
        return x;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public double getScaleX() {
        return scaleX;
    }
    
    public void setScaleX(double scaleX) {
        this.scaleX = scaleX;
    }

    public double getScaleY() {
        return scaleY;
    }

    public void setScaleY(double scaleY) {
        this.scaleY = scaleY;
    }
    
    public double getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }
    
    public String getStroke() {
        return stroke;
    }
    
    public void setStroke(String stroke) {
        this.stroke = stroke;
    }
    
    public double getRotation() {
        return rotation;
    }
    
    public void setRotation(double rotation) {
        this.rotation = rotation;
    }
    
    
    //    public abstract Object getAttributes();
//    public abstract Object getAttributes();
//    public abstract void setAttributes(ShapeDTO data);
// @Override
// public String toString() {
//     return "Shape{" +
//     "x=" + x +
//             ", y=" + y +
//             ", fill='" + fill + '\'' +
//             '}';
// }
}
