package com.oop_paint.Interfaces;

public interface CommandInvoker {

//    void save(String fileFormat, String path, Main data) throws IOException;
//
//    Main load(String fileFormat, String path) throws IOException;

    void undo();
    void redo();
}
