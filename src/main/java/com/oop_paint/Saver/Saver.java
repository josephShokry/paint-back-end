package com.oop_paint.Saver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oop_paint.Database.Database;
import java.io.File;
import java.io.IOException;

public class Saver {

    private ObjectMapper mapper ;
    private String path;
    private Database database = Database.getInstance();
    public void save() throws IOException {
        mapper.writeValue(new File(path),database);

    }
    public void saveStage(Object stage) throws IOException {
        mapper.writeValue(new File(path),stage);
    }
    public void load() throws IOException {
        File file = new File(path);
        Database data = (Database) mapper.readValue(file, Database.class);
        database.setCurrentShapes(data.getCurrentShapes());
        database.setRedoStack(data.getRedoStack());
        database.setUndoStack(data.getUndoStack());
        database.setIdCounter(data.getIdCounter());
    }
    public Object loadStage() throws IOException {
        File file = new File(path);
        return mapper.readValue(file, Object.class);
    }

    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
