package com.oop_paint.Database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oop_paint.Commands.Command;
import com.oop_paint.Saver.Saver;
import com.oop_paint.Saver.SaverFactory;
import com.oop_paint.Shapes.Shape;
import com.oop_paint.Shapes.ShapeDTO;
import java.io.IOException;
import java.util.HashMap;
import java.util.Stack;

public class Database {
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    private HashMap<String, Shape> currentShapes = new HashMap<>();
    private int idCounter = 0;
    @JsonIgnore
    private static Database database = null;


    private Database() {
    }

    public static Database getInstance(){
        if(database == null) database = new Database();
        return database;
    }
    public ShapeDTO undo(){
        try {
            Command command = undoStack.peek();
            undoStack.pop();
            command.undo();
            redoStack.push(command);
            return command.data;
        }
        catch (Exception e){
            return null;
        }
    }
    public ShapeDTO redo(){
        try {
            Command command = redoStack.peek();
            undoStack.push(command);
            redoStack.pop();
            command.redo();
            return command.data;
        }
        catch (Exception e){
            return null;
        }

    }
    public void save(ShapeDTO shapeDTO) throws IOException {
        SaverFactory saverFactory = new SaverFactory(shapeDTO);
        Saver saver = saverFactory.getSaver();
        saver.save();
    }
    public Object load(String path) throws IOException {
        this.clear();
        ShapeDTO data = new ShapeDTO();
        data.path = path;
        SaverFactory saverFactory = new SaverFactory(data);
        Saver saver = saverFactory.getSaver();
        return saver.load();
    }

    public String addShape(Shape shape){
        if(shape.getId()==null){
            String id = "s"+idCounter++;
            shape.setId(id);
        }
        currentShapes.put(shape.getId(),shape);
        return shape.getId();
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
        clearUndoStack();
        clearRedoStack();
        clearShapesList();
    }
    public void clearUndoStack(){
        undoStack.clear();
    }
    public void clearRedoStack(){
        redoStack.clear();
    }
    public void clearShapesList(){
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

    public int getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }

    public static Database getDatabase() {
        return database;
    }

    public static void setDatabase(Database database) {
        Database.database = database;
    }
}
