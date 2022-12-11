package com.oop_paint;

import com.oop_paint.commands.Command;
import com.oop_paint.commands.CommandFactory;
import com.oop_paint.database.Database;
import com.oop_paint.shapes.ShapeDTO;

import java.io.IOException;

public class Paint {
    Database database = Database.getInstance();
    CommandFactory commandFactory = new CommandFactory();
    public ShapeDTO draw(ShapeDTO shapeDTO){
        Command command = commandFactory.getCommand(shapeDTO);
        database.addCommand(command);
        command.execute();
        database.clearRedoStack();
        return command.data;
    }
    public ShapeDTO undo(){
        return database.undo();
    }
    public ShapeDTO redo(){
        return database.redo();
    }
    public void update(ShapeDTO shapeDTO){
        Command command = commandFactory.getCommand(shapeDTO);
        database.addCommand(command);
        command.execute();
        database.clearRedoStack();
    }
    public void save(ShapeDTO shapeDTO) throws IOException {
        database.save(shapeDTO);
    }
    public Object load(String path) throws IOException {
        return database.load((path));
    }
}
