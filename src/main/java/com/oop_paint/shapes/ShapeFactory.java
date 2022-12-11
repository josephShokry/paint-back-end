package com.oop_paint.Shapes;

public class ShapeFactory {
    public Shape getShape(String shapeType){
        switch (shapeType){
            case "Circle": return new Circle();
            case "square": return new Square();
            case "Rect": return new Rectangle();
            case "Ellipse": return new Ellipse();
            case "segmentline" : return new SegmentLine();
            default:return null;
        }
    }
}
