package com.oop_paint.Commands;

import com.oop_paint.Interfaces.Command;
import com.oop_paint.Interfaces.DTO;

public class CommandFactory {
    public Command getCommand(DTO commandDetails){
        switch (commandDetails.commandName){
            case "move": return new Move();
            default: return null;
        }
    }
}
