package com.oop_paint;

import com.oop_paint.commands.Command;
import com.oop_paint.database.Database;
import com.oop_paint.shapes.ShapeDTO;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    Paint paint = new Paint();
    Database database = Database.getInstance();
    @PostMapping("/draw")
    public void draw(@RequestBody ShapeDTO shapeDTO){
        //TODO return the id of the created shape
        paint.draw(shapeDTO);
        System.out.println(database.toString());
    }
    @GetMapping("/undo")
    public Command undo(){
        //TODO send the whole object after undo
        System.out.println(database.toString());
        return paint.undo();
    }
    @PostMapping("/redo")
    public void redo(){
        //TODO send the whole object after redo
        paint.redo();
        System.out.println(database.toString());
    }
    @PutMapping("/update")
    public void update(@RequestBody ShapeDTO shapeDTO){
        paint.update(shapeDTO);
        System.out.println(database.toString());
    }
    @PostMapping("/save")
    public void save(@RequestBody ShapeDTO shapeDTO) throws IOException {
        paint.save(shapeDTO);
    }
    @PostMapping("/load")
    public void load(@RequestBody ShapeDTO shapeDTO) throws IOException {
        //TODO return the stage and get stage
        paint.load(shapeDTO);
    }
    @PostMapping("/get")
    public void printt(@RequestBody ShapeDTO object){
        ShapeDTO ldjf = object;
        System.out.println(object.toString());
    }
}
