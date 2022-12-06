package com.oop_paint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oop_paint.Commands.CommandFactory;
import com.oop_paint.Interfaces.Command;
//import com.oop_paint.Interfaces.Saver;
import com.oop_paint.Interfaces.Shape;
//import com.oop_paint.Savers.SaverFactory;

import java.util.HashMap;

import java.util.Stack;


public class CommandInvoker implements com.oop_paint.Interfaces.CommandInvoker {
    private HashMap<Integer,Shape> currentShapes = new HashMap<Integer,Shape>();
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();
    @JsonIgnore
    private CommandFactory commandFactory = new CommandFactory();
//    @JsonIgnore
//    private SaverFactory saverFactory = new SaverFactory();



//    @Override
//    public void save(String fileFormat, String path, Main data) throws IOException {
//        Saver saver = saverFactory.getSaver(fileFormat);
//        saver.setData(data);
//        saver.setPath(path);
//        saver.serialize();
//    }

//    @Override
//    public Main load(String fileFormat, String path) throws IOException {
//        Saver saver = saverFactory.getSaver(fileFormat);
//        saver.setPath(path);
//        return (Main) saver.deserialize();
////        return (Main) saverFactory.getSaver(dto,null).deserialize();
//    }

    @Override
    public void undo() {
        Command command = undoStack.peek();
        undoStack.pop();
        redoStack.push(command);
        command.undo();
        System.out.println(this.toString());
    }

    @Override
    public void redo() {
        Command command = redoStack.peek();
        redoStack.pop();
        undoStack.push(command);
        command.redo();
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Main{" +
                "currentShapes=" + currentShapes.toString() +
                ", undoStack=" + undoStack.toString() +
                ", redoStack=" + redoStack.toString() +
                '}';
    }

    public void execute(DTO dto){
        Command command = commandFactory.getCommand(dto);
        command.execute();
        undoStack.push(command);
        System.out.println(this.toString());
    }
    public HashMap<Integer, Shape> getCurrentShapes() {
        return currentShapes;
    }

    public void setCurrentShapes(HashMap<Integer, Shape> currentShapes) {
        this.currentShapes = currentShapes;
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

}
