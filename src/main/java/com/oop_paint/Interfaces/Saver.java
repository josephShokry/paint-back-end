package com.oop_paint.Interfaces;

import java.io.IOException;

public interface Saver {
    void serialize() throws IOException;
    MainProgram deserialize() throws IOException;

}
