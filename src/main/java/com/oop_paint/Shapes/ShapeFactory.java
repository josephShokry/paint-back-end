package com.oop_paint.shapes;

public class ShapeFactory {
    public Shape getShape(String shapeType){
        switch (shapeType){
            case "circle": return new Circle();
            case "square": return new Square();
            case "rectangle": return new Rectangle();
            case "ellipse": return new Ellipse();
            case "segmentline" : return new SegmentLine();
            default:return null;
        }
    }
}