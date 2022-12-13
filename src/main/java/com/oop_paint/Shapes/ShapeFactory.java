package com.oop_paint.Shapes;

public class ShapeFactory {
    public Shape getShape(ShapeDTO data){
        switch (data.className){
            case "Circle": return new Circle(data);
            case "square": return new Square(data);
            case "Rect": return new Rectangle(data);
            case "Ellipse": return new Ellipse(data);
            case "segmentline" : return new SegmentLine(data);
            // case "Line" : return new Triangle(data);
            default:return null;
        }
    }
}
