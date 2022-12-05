package com.oop_paint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oop_paint.Commands.CommandFactory;
import com.oop_paint.Interfaces.Command;
import com.oop_paint.Interfaces.MainProgram;
//import com.oop_paint.Interfaces.Saver;
import com.oop_paint.Interfaces.Shape;
//import com.oop_paint.Savers.SaverFactory;

import java.io.IOException;
import java.util.HashMap;

import java.util.Stack;


public class Main implements MainProgram {
    private HashMap<Integer,Shape> currentShapes = new HashMap<Integer,Shape>();
    private Stack<Command> doneCommands = new Stack<>();
    private Stack<Command> undoneCommands = new Stack<>();
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
        Command command = doneCommands.peek();
        doneCommands.pop();
        undoneCommands.push(command);
        command.undo();
        print();
    }

    @Override
    public void redo() {
        Command command = undoneCommands.peek();
        undoneCommands.pop();
        doneCommands.push(command);
        command.redo();
        print();
    }

    public void execute(DTO dto){
        Command command = commandFactory.getCommand(dto);
        command.execute();
        doneCommands.push(command);
        print();
    }
    public HashMap<Integer, Shape> getCurrentShapes() {
        return currentShapes;
    }

    public void setCurrentShapes(HashMap<Integer, Shape> currentShapes) {
        this.currentShapes = currentShapes;
    }

    public Stack<Command> getDoneCommands() {
        return doneCommands;
    }

    public void setDoneCommands(Stack<Command> doneCommands) {
        this.doneCommands = doneCommands;
    }

    public Stack<Command> getUndoneCommands() {
        return undoneCommands;
    }

    public void setUndoneCommands(Stack<Command> undoneCommands) {
        this.undoneCommands = undoneCommands;
    }

    private void print(){
        System.out.println("the shapes " + currentShapes.toString());
        System.out.println("the done " + doneCommands.toString());
        System.out.println("the undone " + undoneCommands.toString());
    }
}
