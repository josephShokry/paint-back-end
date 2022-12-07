package com.oop_paint.Interfaces;

import java.io.IOException;

public interface ICommandInvoker {

    void save(String fileFormat, String path, ICommandInvoker data) throws IOException;


    ICommandInvoker load(String fileFormat, String path) throws IOException;

    void undo();
    void redo();
}
