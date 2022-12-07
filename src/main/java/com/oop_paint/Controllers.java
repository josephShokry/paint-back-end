package com.oop_paint;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Controllers {
    CommandInvoker commandInvoker = new CommandInvoker();

    @PostMapping("/undo")
    void undo(){
        commandInvoker.undo();
    }

    @PostMapping("/redo")
    void redo(){
        commandInvoker.redo();
    }

    @PostMapping("/save")
    void save(@RequestBody DTO dto) throws IOException {
        System.out.println(commandInvoker.toString());
        commandInvoker.save(dto.fileType, dto.path, commandInvoker);
    }

    @PostMapping("/load")
    CommandInvoker load(@RequestBody DTO dto) throws IOException {
        commandInvoker = (CommandInvoker) commandInvoker.load(dto.fileType, dto.path);
        return commandInvoker;
    }

    @PostMapping("/execute")
    void execute(@RequestBody DTO dto){
        commandInvoker.execute(dto);
    }
}
