package com.oop_paint.Savers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oop_paint.Interfaces.ICommandInvoker;
import com.oop_paint.Interfaces.Saver;
import com.oop_paint.CommandInvoker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class JSON implements Saver {
    private String path;
    private Object data;
    private ObjectMapper mapper = new ObjectMapper();
    private static JSON json = null;

    private JSON() {
    }

    public static JSON getInstance(){
        if(json == null) json = new JSON();
        return json;
    }

    @Override
    public void serialize() throws IOException {
        mapper.writeValue(Paths.get(path).toFile(), data);
    }

    @Override
    public ICommandInvoker deserialize() throws IOException {
        File file = new File(path);
        return mapper.readValue(file, CommandInvoker.class);
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }
    public void setPath(String path){
        this.path = path;
    }
}
