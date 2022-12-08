package com.oop_paint.shapes;

import com.oop_paint.database.Database;

public abstract class Shape {
    private int x;
    private int y;
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public abstract void setAttributes(ShapeDTO shapeDTO);


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
