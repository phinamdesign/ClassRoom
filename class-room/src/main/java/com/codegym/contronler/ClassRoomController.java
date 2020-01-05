package com.codegym.contronler;

import com.codegym.model.ClassRoom;
import com.codegym.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ClassRoomController {
    @Autowired
    private ClassRoomService classRoomService;
    @GetMapping("/class")
    public ResponseEntity<?> listClass(){
       List<ClassRoom> classRooms = (List<ClassRoom>) classRoomService.findAll();
       if (classRooms.isEmpty()){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<>(classRooms, HttpStatus.OK);
    }

    @GetMapping("/class/{id}")
    public ResponseEntity<?> getClass(@PathVariable Long id){
        Optional<ClassRoom> classRoom = classRoomService.findById(id);
        if (!classRoom.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(classRoom, HttpStatus.OK);
    }

    @PostMapping("/class")
    public ResponseEntity<?> createClass(@Valid @RequestBody ClassRoom classRoom){
        classRoomService.save(classRoom);
        return new ResponseEntity<>(classRoom, HttpStatus.CREATED);
    }

    @PutMapping("/class/{id}")
    public ResponseEntity<?> updateClass(@Valid @RequestBody ClassRoom classRoom, @PathVariable Long id){
        Optional<ClassRoom> classRoom1 = classRoomService.findById(id);
        if (!classRoom1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        classRoom1.get().setName(classRoom.getName());
        return new ResponseEntity<>(classRoom1, HttpStatus.OK);
    }

    @DeleteMapping("/class/{id}")
    public ResponseEntity<?> deleteClass(@PathVariable Long id){
        Optional<ClassRoom> classRoom = classRoomService.findById(id);
        if (!classRoom.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        classRoomService.delete(id);
        return new ResponseEntity<>(classRoom, HttpStatus.NO_CONTENT);
    }
}
