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
        String message = "";
        for (int i = 0; i < seeInfo.size(); i++) {
            if (day.getId().equals(seeInfo.get(i).getId())) {
                if (day.getName() != null) {
                    seeInfo.get(i).setName(day.getName());
                } else {
                    seeInfo.get(i).setName(seeInfo.get(i).getName());
                }
                day = seeInfo.get(i);
                dayService.save(day);
                return ResponseEntity.ok(day);
            }else {
                message = "not";
            }
        }
        if(message.equals("not")){
            return ResponseEntity.ok('"' + "id" + '"' + ":"  + '"' + day.getId() + '"' + " information not found");
        }
        return ResponseEntity.ok(day);
    }
    @DeleteMapping("/deleteById/{id}")
    public String deleteId(@PathVariable Long id){
        dayService.deleteById(id);
        return id + " deleted";
    }
    @DeleteMapping("/deletAll")
    public String deleteAll(){
        dayService.deleteAll();
        return "AllDeleted";
    }
}
