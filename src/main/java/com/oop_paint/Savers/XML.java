package com.oop_paint.Savers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.oop_paint.Interfaces.MainProgram;
import com.oop_paint.Interfaces.Saver;
import com.oop_paint.Main;

import java.io.File;
import java.io.IOException;


public class XML implements Saver {
    private String path;
    private Object data;
    XmlMapper xmlMapper = new XmlMapper();
    public void setData(Object data) {
        this.data = data;
    }

    public XML(String path,Main data) {
        this.path = path;
        this.data = data;
    }

    @Override
    public void serialize() throws IOException {
        xmlMapper.writeValue(new File(path),data);
    }

    @Override
    public MainProgram deserialize() throws IOException {
        File file = new File(path);
        return (MainProgram) xmlMapper.readValue(file,Main.class);
    }
}
