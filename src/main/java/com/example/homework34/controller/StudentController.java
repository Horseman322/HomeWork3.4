package com.example.homework33.controller;



import com.example.homework33.record.StudentRecord;
import com.example.homework33.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
@PostMapping
    public StudentRecord create(@RequestBody @Valid StudentRecord studentRecord){
        return studentService.create(studentRecord);
    }

    @GetMapping("/{id}")
    public StudentRecord read(@PathVariable long id){
        return studentService.read(id);
    }

    @PutMapping("/{id}")
    public StudentRecord update(@PathVariable long id,
                          @RequestBody @Valid StudentRecord studentRecord){
        return studentService.update(id, studentRecord);
    }

    @DeleteMapping("/{id}")
    public StudentRecord delete(@PathVariable long id){
        return studentService.delete(id);
    }

    @GetMapping("/{id}")
    public Collection<StudentRecord> findByAge(@RequestParam int age){
        return studentService.findByAge(age);
    }

}
