package com.oop_paint.Shapes;

import com.oop_paint.Interfaces.Shape;

public class square implements Shape {
    private int x;
    private int y;
    private int width;
    private int hight;
    private String color;

    public square(int x, int y, int width, int hight) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.hight = hight;
    }
    public void move(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int getx() {
        return this.x;
    }

    @Override
    public int gety() {
        return this.y;
    }

    @Override
    public String toString() {
        return "square{" +
                "x=" + x +
                ", y=" + y +
                ", width=" + width +
                ", hight=" + hight +
                ", color='" + color + '\'' +
                '}';
    }
}
