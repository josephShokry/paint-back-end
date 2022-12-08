package com.oop_paint;

import com.oop_paint.database.Database;
import com.oop_paint.shapes.ShapeDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Paint paint = new Paint();
    Database database = Database.getInstance();
    @PostMapping("/draw")
    public void draw(@RequestBody ShapeDTO shapeDTO){
        paint.draw(shapeDTO);
        System.out.println(database.toString());
    }
    @PostMapping("/undo")
    public void undo(){
        paint.undo();
        System.out.println(database.toString());
    }
    @PostMapping("/redo")
    public void redo(){
        paint.redo();
        System.out.println(database.toString());
    }
    @PutMapping("/update")
    public void update(@RequestBody ShapeDTO shapeDTO){
        paint.update(shapeDTO);
        System.out.println(database.toString());
    }
}
