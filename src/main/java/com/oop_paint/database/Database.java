package com.oop_paint.database;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.oop_paint.commands.Command;
import com.oop_paint.saver.Saver;
import com.oop_paint.saver.SaverFactory;
import com.oop_paint.shapes.Shape;

import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

public class Database {
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    private HashMap<String, Shape> currentShapes = new HashMap<>();
    @JsonIgnore
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
    public void save(String path) throws IOException {
        SaverFactory saverFactory = new SaverFactory(path);
        Saver saver = saverFactory.getSaver();
        saver.save();
    }
    public void load(String path) throws IOException {
        this.clear();
        SaverFactory saverFactory = new SaverFactory(path);
        Saver saver = saverFactory.getSaver();
        saver.load();
    }
    public void addShape(Shape shape){
        currentShapes.put(shape.getId(),shape);
    }
    public void deleteShape(String id){
        currentShapes.remove(id);
    }

    public void addCommand(Command command){
        undoStack.push(command);
    }
    public Shape getShape(String id){
        return currentShapes.get(id);
    }
    private void clear(){
        undoStack.clear();
        redoStack.clear();
        currentShapes.clear();
    }
    @Override
    public String toString() {
        return "Database{" +
                "undoStack=" + undoStack +
                ", redoStack=" + redoStack +
                ", currentShapes=" + currentShapes +
                '}';
    }

    public Stack<Command> getUndoStack() {
        return undoStack;
    }

    public void setUndoStack(Stack<Command> undoStack) {
        this.undoStack = undoStack;
    }

    public Stack<Command> getRedoStack() {
        return redoStack;
    }

    public void setRedoStack(Stack<Command> redoStack) {
        this.redoStack = redoStack;
    }

    public HashMap<String, Shape> getCurrentShapes() {
        return currentShapes;
    }

    public void setCurrentShapes(HashMap<String, Shape> currentShapes) {
        this.currentShapes = currentShapes;
    }
}
