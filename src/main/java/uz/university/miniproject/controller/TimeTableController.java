package uz.university.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.university.miniproject.entity.model.Teacher;
import uz.university.miniproject.entity.model.TimeTable;
import uz.university.miniproject.service.TimeTableService;

import java.util.List;

@RestController
@RequestMapping("/api/timeTable")
public class TimeTableController {
    //
    @Autowired
    private TimeTableService tableService;

    @PostMapping("/createInfo")
    public ResponseEntity createInfo(@RequestBody TimeTable timeTable){
        return ResponseEntity.ok(tableService.save(timeTable));
    }
    @GetMapping("/showInfo")
    public ResponseEntity showInfo(){
        return ResponseEntity.ok(tableService.findAll());
    }
    @GetMapping("/showIdInfo")
    public ResponseEntity showById(@RequestBody TimeTable timeTable){
        return ResponseEntity.ok(tableService.findById(timeTable.getId()));
    }
    @PutMapping("/changeInfo")
    public ResponseEntity changeInfo(@RequestBody TimeTable timeTable){
        List<TimeTable> seeInfo = tableService.findAll();
        String message = "";
        for (int i = 0; i < seeInfo.size(); i++) {
            if(timeTable.getId().equals(seeInfo.get(i).getId())){
                if(timeTable.getStart_time() != null){
                    seeInfo.get(i).setStart_time(timeTable.getStart_time());
                }else {
                    seeInfo.get(i).setStart_time(seeInfo.get(i).getStart_time());
                }
                if(timeTable.getEnd_time() != null){
                    seeInfo.get(i).setEnd_time(timeTable.getEnd_time());
                }else {
                    seeInfo.get(i).setEnd_time(seeInfo.get(i).getEnd_time());
                }
                timeTable = seeInfo.get(i);
                tableService.save(timeTable);
                return ResponseEntity.ok(timeTable);
            }else {
                message = "not";
            }
        }
        if (message.equals("not")){
            return ResponseEntity.ok('"' + "id" + '"' + ":"  + '"' + timeTable.getId() + '"' + " information not found");
        }
        return ResponseEntity.ok(timeTable);
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        tableService.deleteAll();
        return "AllDeleted";
    }
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable Long id){
        tableService.deleteById(id);
        return id + " deleted";
    }
}
