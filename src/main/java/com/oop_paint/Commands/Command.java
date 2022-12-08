package com.oop_paint.commands;

public interface Command {
    void undo();
    void redo();
    void execute();
}
