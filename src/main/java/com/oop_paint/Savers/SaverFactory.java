package com.oop_paint.Savers;

import com.oop_paint.Interfaces.DTO;
import com.oop_paint.Interfaces.Saver;
import com.oop_paint.Main;

public class SaverFactory {
    public Saver getSaver(DTO dto, Main data){
        switch (dto.fileType){
            case "xml": return new XML(dto.path,data);
            default:return null;
        }
    }
}
