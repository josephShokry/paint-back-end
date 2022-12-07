package com.oop_paint;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

//    @PostMapping("/save")
//    void save(@RequestBody DTO dto) throws IOException {
////        System.out.println(main.toString());
//        main.save(dto.fileType, dto.path, main);
//    }

//    @PostMapping("/load")
//    Main load(@RequestBody DTO dto) throws IOException {
//        main = main.load(dto.fileType, dto.path);
//        return main;
//    }

    @PostMapping("/execute")
    void execute(@RequestBody DTO dto){
        commandInvoker.execute(dto);
    }
}
