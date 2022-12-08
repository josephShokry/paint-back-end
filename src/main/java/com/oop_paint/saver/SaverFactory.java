package com.oop_paint.saver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class SaverFactory {
    private String path;
    private String type;
    private Saver saver = new Saver();

    public SaverFactory(String path) {
        this.path = path;
        this.type = path.substring(path.indexOf('.')+1);
        saver.setPath(path);
    }
    public Saver getSaver(){
        switch (type){
            case "json": saver.setMapper(new JsonMapper()); return saver;
            case "xml" : saver.setMapper(new XmlMapper()); return saver;
            default: return null;

        }
    }
}
