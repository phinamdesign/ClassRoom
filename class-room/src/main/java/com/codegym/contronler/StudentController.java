package com.codegym.contronler;

import com.codegym.model.ClassRoom;
import com.codegym.model.Student;
import com.codegym.service.ClassRoomService;
import com.codegym.service.StudentService;
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
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassRoomService classRoomService;

    @ModelAttribute("classRoom")
    public Iterable<ClassRoom> categories(){
        return classRoomService.findAll();
    }


    @GetMapping("/student")
    public ResponseEntity<?> listStudent(){
        List<Student> students = (List<Student>) studentService.findAll();
        if (students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id){
        Optional<Student> student = studentService.findById(id);
        if (!student.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<?> updateStudent(@Valid @RequestBody Student student, @PathVariable Long id){
        Optional<Student> student1 = studentService.findById(id);
        if (!student1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        student1.get().setName(student.getName());
        student1.get().setAge(student.getAge());
        return new ResponseEntity<>(student1, HttpStatus.OK);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        Optional<Student> student = studentService.findById(id);
        if (!student.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.delete(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
