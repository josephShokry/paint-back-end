package com.oop_paint.Saver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oop_paint.Database.Database;
import java.io.File;
import java.io.IOException;

public class Saver {

    private ObjectMapper mapper;
    private String path;
    private String stagePath;
    private Object stage;
    private Database database = Database.getInstance();

    public void save() throws IOException {
        mapper.writeValue(new File(path),database);
        mapper.writeValue(new File(stagePath),stage);
    }

    public Object load() throws IOException {
        File file = new File(path);
        Database data = mapper.readValue(file, Database.class);
//        database = data;
        database.setCurrentShapes(data.getCurrentShapes());
        database.setRedoStack(data.getRedoStack());
        database.setUndoStack(data.getUndoStack());
        database.setIdCounter(data.getIdCounter());
        return mapper.readValue(new File(stagePath), Object.class);
    }

    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getStage() {
        return stage;
    }

    public void setStage(Object stage) {
        this.stage = stage;
    }

    public String getStagePath() {
        return stagePath;
    }

    public void setStagePath(String stagePath) {
        this.stagePath = stagePath;
    }
}
