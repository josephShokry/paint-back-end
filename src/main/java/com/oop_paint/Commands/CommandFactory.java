package com.oop_paint.Commands;

import com.oop_paint.Interfaces.Command;
import com.oop_paint.DTO;

public class CommandFactory {
    public Command getCommand(DTO commandDetails){
        //todo: the reset of commands will be added here
        switch (commandDetails.commandName){
            case "move": return new Move();
            default: return null;
        }
    }
}
