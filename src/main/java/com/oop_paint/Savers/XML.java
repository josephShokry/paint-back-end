package com.oop_paint.Savers;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.oop_paint.Interfaces.ICommandInvoker;
import com.oop_paint.Interfaces.Saver;
import com.oop_paint.CommandInvoker;

import java.io.File;
import java.io.IOException;


public class XML implements Saver {
    private String path;
    private Object data;
    private XmlMapper xmlMapper = new XmlMapper();
    private static XML xml = null;

    private XML() {
    }

    public static XML getInstance(){
        if(xml == null) xml = new XML();
        return xml;
    }
    @Override
    public void setData(Object data) {
        this.data = data;
    }



    @Override
    public void serialize() throws IOException {
        xmlMapper.writeValue(new File(path),data);
    }

    @Override
    public ICommandInvoker deserialize() throws IOException {
        File file = new File(path);
        return (ICommandInvoker) xmlMapper.readValue(file, CommandInvoker.class);
    }
    public void setPath(String path){
        this.path = path;
    }
}
