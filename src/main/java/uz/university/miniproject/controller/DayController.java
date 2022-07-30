package uz.university.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.university.miniproject.entity.model.Day;
import uz.university.miniproject.service.DayService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/day")
public class DayController {
    //
    @Autowired
    private DayService dayService;

    @PostMapping("createInfo")
    public ResponseEntity postMethod(@RequestBody Day day){
        return ResponseEntity.ok(dayService.save(day));
    }
    @GetMapping("showInfo")
    public ResponseEntity getMethod(){
        List<Day> seeInfo = dayService.findAll();
        return ResponseEntity.ok(seeInfo);
    }
    @GetMapping("/showIdInfo")
    public ResponseEntity getIdMethod(@RequestBody Day day){
        Optional<Day> seeInfo = dayService.findById(day.getId());
        return ResponseEntity.ok(seeInfo) ;
    }
    @PutMapping("/changeInfo")
    public ResponseEntity putMethod(@RequestBody Day day){
        List<Day> seeInfo = dayService.findAll();
        for (Day value : seeInfo) {
            if (day.getId().equals(value.getId())) {
                if (day.getName() != null) {
                    value.setName(day.getName());
                } else {
                    value.setName(value.getName());
                }
                day = value;
                dayService.save(day);
            }
        }
        return ResponseEntity.ok(day);
    }
    @DeleteMapping("/deleteById")
    public String deleteId(@RequestBody Day day){
        dayService.deleteById(day.getId());
        return day.getId() + " deleted";
    }
    @DeleteMapping("/deletAll")
    public String deleteAll(){
        dayService.deleteAll();
        return "AllDeleted";
    }
}