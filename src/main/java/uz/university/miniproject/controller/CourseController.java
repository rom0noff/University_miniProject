package uz.university.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.university.miniproject.entity.model.Course;
import uz.university.miniproject.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    //
    @Autowired
    private CourseService courseService;

    @PostMapping("/createInfo")
    public ResponseEntity postMethod(@RequestBody Course course){
        return ResponseEntity.ok(courseService.save(course));
    }
    @GetMapping("/showInfo")
    public ResponseEntity getMethod(){
        List<Course> seeInfo = courseService.findAll();
        return ResponseEntity.ok(seeInfo);
    }
    @GetMapping("/showIdInfo")
    public ResponseEntity getIdMethod(@RequestBody Course course){
        Optional<Course> seeInfo = courseService.findById(course.getId());
        return ResponseEntity.ok(seeInfo) ;
    }
    @PutMapping("/changeInfo")
    public ResponseEntity putMethod(@RequestBody Course course){
        List<Course> seeInfo = courseService.findAll();
        for (Course value : seeInfo) {
            if (course.getId().equals(value.getId())) {
                if (course.getDuration() != null) {
                    value.setDuration(course.getDuration());
                } else {
                    value.setDuration(value.getDuration());
                }
                if (course.getName() != null) {
                    value.setName(course.getName());
                } else {
                    value.setName(value.getName());
                }
                if (course.getPrice() != null) {
                    value.setPrice(course.getPrice());
                } else {
                    value.setPrice(value.getPrice());
                }
                course = value;
                courseService.save(course);
            }
        }
        return ResponseEntity.ok(course);
    }
    @DeleteMapping("/deleteById")
    public String deleteIdMethod(@RequestBody Course course){
        courseService.deleteById(course.getId());
        return course.getId() + " deleted";
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        courseService.deleteAll();
        return "AllDeleted";
    }
}
