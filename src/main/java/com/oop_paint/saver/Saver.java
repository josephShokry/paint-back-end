package com.oop_paint.saver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oop_paint.database.Database;


import java.io.File;
import java.io.IOException;

public class Saver {

    private ObjectMapper mapper ;
    private String path;
    private Database database = Database.getInstance();
    public void save() throws IOException {
        mapper.writeValue(new File(path),database);
    }
    public void load() throws IOException {
        File file = new File(path);
        Database data = (Database) mapper.readValue(file, Database.class);
        database.setCurrentShapes(data.getCurrentShapes());
        database.setRedoStack(data.getRedoStack());
        database.setUndoStack(data.getUndoStack());
    }

    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
