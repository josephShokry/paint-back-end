package com.oop_paint.shapes;

public class ShapeFactory {
    public Shape getShape(String shapeType){
        switch (shapeType){
            case "circle": return new Circle();
            case "square": return new Square();
            default:return null;
        }
    }
}
