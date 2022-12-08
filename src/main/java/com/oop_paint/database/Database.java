package com.oop_paint.database;

import com.oop_paint.commands.Command;
import com.oop_paint.shapes.Shape;

import java.util.HashMap;
import java.util.Stack;

public class Database {
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();
    private HashMap<String, Shape> currentShapes = new HashMap<>();
    private static Database database = null;

    private Database() {
    }

    public static Database getInstance(){
        if(database == null) database = new Database();
        return database;
    }
    public void undo(){
        Command command = undoStack.peek();
        redoStack.push(command);
        undoStack.pop();
        command.undo();
    }
    public void redo(){
        Command command = redoStack.peek();
        undoStack.push(command);
        redoStack.pop();
        command.redo();
    }
    public void save(String path){
        //todo:implement the saver
    }
    public void load(String path){
        //todo:implement the saver
    }
    public void addShape(Shape shape){
        currentShapes.put(String.valueOf(shape.getId()),shape);
    }
    public void deleteShape(int id){
        currentShapes.remove(String.valueOf(id));
    }

    public void addCommand(Command command){
        undoStack.push(command);
    }
    public Shape getShape(int id){
        return currentShapes.get(String.valueOf(id));
    }

    @Override
    public String toString() {
        return "Database{" +
                "undoStack=" + undoStack +
                ", redoStack=" + redoStack +
                ", currentShapes=" + currentShapes +
                '}';
    }
}
