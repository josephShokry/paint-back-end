package com.oop_paint.commands;

import com.oop_paint.shapes.Circle;
import com.oop_paint.shapes.Shape;
import com.oop_paint.shapes.ShapeDTO;

public class CommandFactory {
    public Command getCommand(ShapeDTO shapeDTO){
        String commandType = shapeDTO.commandType;
        switch (commandType){
            case "draw": return new Draw(shapeDTO);
            case "recolor": return new Recolor(shapeDTO);
            case "move" : return new Move(shapeDTO);
            case "resize" : return new Resize(shapeDTO);
            case "delete" : return new Delete(shapeDTO);
            case "clone" : return new Clone(shapeDTO);
            default:return null;
        }
    }
}
