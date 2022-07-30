package uz.university.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.university.miniproject.entity.model.Student;
import uz.university.miniproject.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    //
    @Autowired
    private StudentService studentService;

    @PostMapping("/createInfo")
    public ResponseEntity createInfo(@RequestBody Student student){
        return ResponseEntity.ok(studentService.save(student));
    }
    @GetMapping("/showInfo")
    public ResponseEntity showInfo(){
        return ResponseEntity.ok(studentService.findAll());
    }
    @GetMapping("/showIdInfo")
    public ResponseEntity showById(@RequestBody Student student){
        return ResponseEntity.ok(studentService.findById(student.getId()));
    }
    @PutMapping("/changeInfo")
    public ResponseEntity changeInfo(@RequestBody Student student){
        List<Student> seeInfo = studentService.findAll();
        for (int i = 0; i < seeInfo.size(); i++) {
            if(student.getId().equals(seeInfo.get(i).getId())){
                if(student.getFullName() != null){
                    seeInfo.get(i).setFullName(student.getFullName());
                }else {
                    seeInfo.get(i).setFullName(seeInfo.get(i).getFullName());
                }
                if(student.getPhone() != null){
                    seeInfo.get(i).setPhone(student.getPhone());
                }else {
                    seeInfo.get(i).setPhone(seeInfo.get(i).getPhone());
                }
                student = seeInfo.get(i);
                studentService.save(student);
            }
        }
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        studentService.deleteAll();
        return "AllDeleted";
    }
    @DeleteMapping("/deleteById")
    public String deleteById(@RequestBody Student student){
        studentService.deleteById(student.getId());
        return student.getId() + " deleted";
    }
}
