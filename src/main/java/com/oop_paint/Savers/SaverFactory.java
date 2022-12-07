package com.oop_paint.Savers;

import com.oop_paint.Interfaces.Saver;

public class SaverFactory {
    public Saver getSaver(String saverType){
        switch (saverType){
            case "xml":
                return XML.getInstance();
            case "json":
                return JSON.getInstance();
            default: return null;
        }
    }
}
