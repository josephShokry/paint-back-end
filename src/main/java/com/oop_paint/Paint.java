package com.oop_paint;

import com.oop_paint.commands.Command;
import com.oop_paint.commands.CommandFactory;
import com.oop_paint.database.Database;
import com.oop_paint.shapes.ShapeDTO;

import java.io.IOException;

public class Paint {
    Database database = Database.getInstance();
    CommandFactory commandFactory = new CommandFactory();
    public void draw(ShapeDTO shapeDTO){
        Command command = commandFactory.getCommand(shapeDTO);
        database.addCommand(command);
        command.execute();
    }
    public Command undo(){
        return database.undo();
    }
    public void redo(){
        database.redo();
    }
    public void update(ShapeDTO shapeDTO){
        Command command = commandFactory.getCommand(shapeDTO);
        database.addCommand(command);
        command.execute();
    }
    public void save(ShapeDTO shapeDTO) throws IOException {
        database.save(shapeDTO.path);
    }
    public void load(ShapeDTO shapeDTO) throws IOException {
        database.load((shapeDTO.path));
    }
}
