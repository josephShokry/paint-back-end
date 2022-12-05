package com.oop_paint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oop_paint.Commands.CommandFactory;
import com.oop_paint.Interfaces.Command;
import com.oop_paint.Interfaces.DTO;
import com.oop_paint.Interfaces.MainProgram;
import com.oop_paint.Interfaces.Shape;
import com.oop_paint.Savers.SaverFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Main implements MainProgram {
    public List<Shape> currentShapes = new ArrayList<>();
    public Stack<Command> doneCommands = new Stack<>();
    public Stack<Command> undoneCommands = new Stack<>();
    @JsonIgnore
    public CommandFactory commandFactory = new CommandFactory();
    @JsonIgnore
    public SaverFactory saverFactory = new SaverFactory();


    @Override
    public void save(DTO dto, Main data) throws IOException {
        saverFactory.getSaver(dto,data).serialize();
    }

    @Override
    public Main load(DTO dto) throws IOException {
        return (Main) saverFactory.getSaver(dto,null).deserialize();
    }

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

    public List<Shape> getCurrentShapes() {
        return currentShapes;
    }

    public List<Command> getDoneCommands() {
        return doneCommands;
    }

    public List<Command> getUndoneCommands() {
        return undoneCommands;
    }

    public void setCurrentShapes(List<Shape> currentShapes) {
        this.currentShapes = currentShapes;
    }

    public void setDoneCommands(Stack<Command> doneCommands) {
        this.doneCommands = doneCommands;
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
