package com.oop_paint.commands;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.oop_paint.shapes.ShapeDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Draw.class, name = "Draw"),
        @JsonSubTypes.Type(value = Recolor.class, name = "Recolor"),
        @JsonSubTypes.Type(value = Delete.class, name = "Delete"),
        @JsonSubTypes.Type(value = Move.class, name = "Move"),
        @JsonSubTypes.Type(value = Resize.class, name = "Resize")
})
public abstract class Command {
    public ShapeDTO data = null;
    public abstract void undo();
    public abstract void redo();
    public abstract void execute();
    public void setData(ShapeDTO data){
        this.data = data;
    }
    public void swap(Object first, Object second){
        Object temp = first;
        first = second;
        second = temp;
    }
}
