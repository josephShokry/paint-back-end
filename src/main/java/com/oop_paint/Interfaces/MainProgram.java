package com.oop_paint.Interfaces;

import com.oop_paint.DTO;
import com.oop_paint.Main;

import java.io.IOException;

public interface MainProgram {

//    void save(String fileFormat, String path, Main data) throws IOException;
//
//    Main load(String fileFormat, String path) throws IOException;

    void undo();
    void redo();
}
