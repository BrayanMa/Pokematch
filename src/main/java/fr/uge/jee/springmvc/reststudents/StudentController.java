package fr.uge.jee.springmvc.reststudents;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

/*@RestController
public class StudentController {

    private final Map<Long,Student> students = Map.of(
            1L, new Student(1L, "MARIE", "Brayan"),
            2L, new Student(2L, "OSAJ", "Xavi")
    );

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id")long id){
        var student = students.get(id);
        if(student == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No student with id ("+id+")");
        } else {
            return student;
        }
    }

    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return List.copyOf(students.values());
    }
}*/
