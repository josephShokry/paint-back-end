package com.oop_paint;

import com.oop_paint.Database.Database;
import com.oop_paint.Shapes.ShapeDTO;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    private final PaintService paint = new PaintService();
    private final Database database = Database.getInstance();
    @PostMapping("/draw")
    public ShapeDTO draw(@RequestBody ShapeDTO shapeDTO){
        System.out.println(database.toString());
        return paint.draw(shapeDTO);
    }
    @GetMapping("/undo")
    public ShapeDTO undo(){
        System.out.println(database.toString());
        return paint.undo();
    }
    @GetMapping("/redo")
    public ShapeDTO redo(){
        System.out.println(database.toString());
        return paint.redo();
    }
    @PutMapping("/update")
    public void update(@RequestBody ShapeDTO shapeDTO){
        paint.update(shapeDTO);
        System.out.println(database.toString());
    }
    @PostMapping("/save")
    public ShapeDTO save(@RequestBody ShapeDTO shapeDTO) throws IOException {
        paint.save(shapeDTO);

        File file = new File(shapeDTO.path);
        Scanner scn = new Scanner(file);
        shapeDTO.saveData = scn.nextLine();
        System.out.println(shapeDTO.saveData);
        return shapeDTO;
    }
    @GetMapping("/load/{path}")
    public Object load(@PathVariable String path) throws IOException {
        return paint.load(path);
    }
    @GetMapping("/clone/{id}")
    public ShapeDTO clone(@PathVariable String id){
        ShapeDTO dto = new ShapeDTO();
        dto.id = id;
        dto.commandType = "clone";
        return paint.draw(dto);
    }
    @PostMapping("/saveTest")
    public void saveTest(ShapeDTO shapeDTO){

    }
}
