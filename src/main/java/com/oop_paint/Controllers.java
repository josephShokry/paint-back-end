package com.oop_paint;

import com.oop_paint.Interfaces.DTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Controllers {
    Main main = new Main();

    @PostMapping("/undo")
    void undo(){
        main.undo();
    }

    @PostMapping("/redo")
    void redo(){
        main.redo();
    }

    @PostMapping("/save")
    void save(@RequestBody DTO dto) throws IOException {
        System.out.println(main.toString());
        main.save(dto,main);
    }

    @PostMapping("/load")
    void load(@RequestBody DTO dto) throws IOException {
        main = main.load(dto);
    }

    @PostMapping("/exectue")
    void execute(@RequestBody DTO dto){
        main.execute(dto);
    }
}
