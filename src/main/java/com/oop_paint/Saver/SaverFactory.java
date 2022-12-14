package com.oop_paint.Saver;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.oop_paint.Shapes.ShapeDTO;

public class SaverFactory {
    private String type;
    private Saver saver = new Saver();

    public SaverFactory(ShapeDTO shapeDTO) {
        String filePath = shapeDTO.path;
        this.type = filePath.substring(filePath.indexOf('.')+1);
        saver.setPath(filePath);
        saver.setStagePath(filePath.substring(0,filePath.indexOf('.')-1)+"stage.json");
        saver.setStage(shapeDTO.stage);
    }
    public Saver getSaver(){
        switch (type){
            case "json": saver.setMapper(new JsonMapper()); return saver;
            case "xml" : saver.setMapper(new XmlMapper()); return saver;
            default: return null;
        }
    }
}
