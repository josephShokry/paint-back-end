package com.oop_paint.commands;

import com.oop_paint.shapes.ShapeDTO;

public class CommandFactory {
    public Command getCommand(ShapeDTO shapeDTO){
        String commandType = shapeDTO.commandType;
        switch (commandType){
            case "draw": return new Draw(shapeDTO);
            case "recolor": return new Recolor(shapeDTO);
            default:return null;
        }
    }
}
