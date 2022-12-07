package com.oop_paint.Interfaces;

import java.io.IOException;

public interface Saver {
    void serialize() throws IOException;
    ICommandInvoker deserialize() throws IOException;
    void setData(Object data);
    void setPath(String path);

}
