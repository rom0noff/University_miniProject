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
        String message = "";
        for (int i = 0; i < seeInfo.size(); i++) {
            if (course.getId().equals(seeInfo.get(i).getId())) {
                if (course.getDuration() != null) {
                    seeInfo.get(i).setDuration(course.getDuration());
                } else {
                    seeInfo.get(i).setDuration(seeInfo.get(i).getDuration());
                }
                if (course.getName() != null) {
                    seeInfo.get(i).setName(course.getName());
                } else {
                    seeInfo.get(i).setName(seeInfo.get(i).getName());
                }
                if (course.getPrice() != null) {
                    seeInfo.get(i).setPrice(course.getPrice());
                } else {
                    seeInfo.get(i).setPrice(seeInfo.get(i).getPrice());
                }
                course = seeInfo.get(i);
                courseService.save(course);
                return ResponseEntity.ok(course);
            }else {
                message = "not";
            }
        }
        if(message.equals("not")){
            return ResponseEntity.ok('"' + "id" + '"' + ":"  + '"' + course.getId() + '"' + " information not found");
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
