package uz.university.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.university.miniproject.entity.model.Teacher;
import uz.university.miniproject.service.StudentService;
import uz.university.miniproject.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    //
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/createInfo")
    public ResponseEntity createInfo(@RequestBody Teacher teacher){
        return ResponseEntity.ok(teacherService.save(teacher));
    }
    @GetMapping("/showInfo")
    public ResponseEntity showInfo(){
        return ResponseEntity.ok(teacherService.findAll());
    }
    @GetMapping("/showIdInfo")
    public ResponseEntity showById(@RequestBody Teacher teacher){
        return ResponseEntity.ok(teacherService.findById(teacher.getId()));
    }
    @PutMapping("/changeInfo")
    public ResponseEntity changeInfo(@RequestBody Teacher teacher){
        List<Teacher> seeInfo = teacherService.findAll();
        String message = "";
        for (int i = 0; i < seeInfo.size(); i++) {
            if(teacher.getId().equals(seeInfo.get(i).getId())){
                if(teacher.getFullName() != null){
                    seeInfo.get(i).setFullName(teacher.getFullName());
                }else {
                    seeInfo.get(i).setFullName(seeInfo.get(i).getFullName());
                }
                if(teacher.getPhone() != null){
                    seeInfo.get(i).setPhone(teacher.getPhone());
                }else {
                    seeInfo.get(i).setPhone(seeInfo.get(i).getPhone());
                }
                if(teacher.getSalary() != null){
                    seeInfo.get(i).setSalary(teacher.getSalary());
                }else {
                    seeInfo.get(i).setSalary(seeInfo.get(i).getSalary());
                }
                teacher = seeInfo.get(i);
                teacherService.save(teacher);
                return ResponseEntity.ok(teacher);
            }else {
                message = "not";
            }
        }
        if (message.equals("not")){
            return ResponseEntity.ok('"' + "id" + '"' + ":"  + '"' + teacher.getId() + '"' + " information not found");
        }
        return ResponseEntity.ok(teacher);
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        teacherService.deleteAll();
        return "AllDeleted";
    }
    @DeleteMapping("/deleteById")
    public String deleteById(@RequestBody Teacher teacher){
        teacherService.deleteById(teacher.getId());
        return teacher.getId() + " deleted";
    }
}
