package com.oop_paint.Interfaces;

import com.oop_paint.Main;

import java.io.IOException;

public interface MainProgram {
    void save(DTO dto, Main data) throws IOException;

    Main load(DTO dto) throws IOException;
    void undo();
    void redo();
}
