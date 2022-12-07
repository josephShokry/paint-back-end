package com.oop_paint.Interfaces;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.oop_paint.Commands.Move;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes( {
        @JsonSubTypes.Type(name = "move", value = Move.class)})
public interface Command {
    void undo();
    void redo();
    void execute();
}
