package uz.university.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.university.miniproject.entity.model.Status;
import uz.university.miniproject.service.StatusService;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {
    //
    @Autowired
    private StatusService statusService;

    @PostMapping("/createInfo")
    public ResponseEntity createInfo(@RequestBody Status status){
        return ResponseEntity.ok(statusService.save(status));
    }
    @GetMapping("/showInfo")
    public ResponseEntity showInfo(){
        return ResponseEntity.ok(statusService.findAll());
    }
    @GetMapping("/showIdInfo")
    public ResponseEntity showIdInfo(@RequestBody Status status){
        return ResponseEntity.ok(statusService.findById(status.getId()));
    }
    @PutMapping("/changeInfo")
    public ResponseEntity changeInfo(@RequestBody Status status){
        List<Status> seeInfo = statusService.findAll();
        String message = "";
        for (int i = 0; i < seeInfo.size(); i++) {
            if(status.getId().equals(seeInfo.get(i).getId())){
                if(status.getName() != null){
                    seeInfo.get(i).setName(status.getName());
                }else {
                    seeInfo.get(i).setName(seeInfo.get(i).getName());
                }
                if(status.getDescription() != null){
                    seeInfo.get(i).setDescription(status.getDescription());
                }else {
                    seeInfo.get(i).setDescription(seeInfo.get(i).getDescription());
                }
                status = seeInfo.get(i);
                statusService.save(status);
                return ResponseEntity.ok(status);
            }else {
                message = "not";
            }
        }
        if(message.equals("not")){
            return ResponseEntity.ok('"' + "id" + '"' + ":"  + '"' + status.getId() + '"' + " information not found");
        }
        return ResponseEntity.ok(status);
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        statusService.deleteAll();
        return "AllDeleted";
    }
    @DeleteMapping("deleteById/{id}")
    public String deleteById(@PathVariable Long id){
        statusService.deleteById(id);
        return id + " deleted";
    }
}
