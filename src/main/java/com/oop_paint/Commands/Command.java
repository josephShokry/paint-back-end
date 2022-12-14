package com.oop_paint.Commands;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.oop_paint.Shapes.ShapeDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Draw.class, name = "Draw"),
        @JsonSubTypes.Type(value = Recolor.class, name = "Recolor"),
        @JsonSubTypes.Type(value = Delete.class, name = "Delete"),
        @JsonSubTypes.Type(value = Move.class, name = "Move"),
        @JsonSubTypes.Type(value = Resize.class, name = "Resize"),
        @JsonSubTypes.Type(value = Clone.class, name = "Clone")
})
public abstract class Command {
    public ShapeDTO data = null;
    public abstract void undo();
    public abstract void redo();
    public abstract void execute();
    public void setData(ShapeDTO data){
        this.data = data;
    }
}
