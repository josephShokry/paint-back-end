package com.oop_paint.Database;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
            redoStack.push(command);
            undoStack.pop();
            command.undo();
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
        SaverFactory saverFactory = new SaverFactory(shapeDTO.path);
        Saver saver = saverFactory.getSaver();
        saver.save();
        saveStage(shapeDTO.stage, shapeDTO.path);
    }
    private void saveStage(Object stage, String path) throws IOException {
        path = path.substring(0,path.indexOf('.')-1)+"stage.json";
        System.out.println(path);
        SaverFactory saverFactory = new SaverFactory(path);
        Saver saver = saverFactory.getSaver();
        saver.saveStage(stage);
    }
    public Object load(String path) throws IOException {
        this.clear();
        SaverFactory saverFactory = new SaverFactory(path);
        Saver saver = saverFactory.getSaver();
        saver.load();
        return loadStage(path);
    }
    private Object loadStage(String path) throws IOException {
        path = path.substring(0,path.indexOf('.')-1)+"stage.json";
        System.out.println(path);
        SaverFactory saverFactory = new SaverFactory(path);
        Saver saver = saverFactory.getSaver();
        return saver.loadStage();
    }
    public String addShape(Shape shape){
        String id = "s"+idCounter++;
        shape.setId(id);
        currentShapes.put(shape.getId(),shape);
        return id;
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
//        undoStack.clear();
//        redoStack.clear();
//        currentShapes.clear();
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
