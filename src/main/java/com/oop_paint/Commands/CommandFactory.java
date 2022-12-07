package com.oop_paint.Commands;

import com.oop_paint.Interfaces.Command;
import com.oop_paint.DTO;
import com.oop_paint.Interfaces.Shape;

public class CommandFactory {
    public Command getCommand(DTO commandDetails, Shape shape){
        //todo: the reset of commands will be added here
        switch (commandDetails.commandName){
            case "move": return new Move(shape, commandDetails.newx,commandDetails.newy);
            default: return null;
        }
    }
}
