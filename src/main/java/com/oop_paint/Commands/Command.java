package com.oop_paint.Commands;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Draw.class, name = "Draw"),
        @JsonSubTypes.Type(value = Recolor.class, name = "Recolor"),
        @JsonSubTypes.Type(value = Delete.class, name = "Delete"),
        @JsonSubTypes.Type(value = Move.class, name = "Move"),
        @JsonSubTypes.Type(value = Resize.class, name = "Resize")
})
public interface Command {
    void undo();
    void redo();
    void execute();
}
