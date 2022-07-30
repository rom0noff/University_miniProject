package uz.university.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.university.miniproject.entity.model.Group;
import uz.university.miniproject.service.GroupService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/group")
public class GroupController {
    //
    @Autowired
    private GroupService groupService;

    @PostMapping("/createInfo")
    public ResponseEntity postMethod(@RequestBody Group group){
       return ResponseEntity.ok(groupService.save(group));
    }
    @GetMapping("/showInfo")
    public ResponseEntity getMethod(){
        return ResponseEntity.ok(groupService.findAll());
    }
    @GetMapping("/showIdInfo")
    public ResponseEntity getIdMethod(@RequestBody Group group){
        Optional<Group> seeInfo = groupService.findById(group.getId());
        return ResponseEntity.ok(seeInfo);
    }
    @PutMapping("changeInfo")
    public ResponseEntity changeMethod(@RequestBody Group group){
        List<Group> seeInfo = groupService.findAll();
        for (Group value : seeInfo) {
            if (group.getId().equals(value.getId())) {
                if (group.getName() != null) {
                    value.setName(group.getName());
                } else {
                    value.setName(value.getName());
                }
                group = value;
                groupService.save(group);
            }
        }
        return ResponseEntity.ok(group);
    }
    @DeleteMapping("/deleteById")
    public String deleteById(@RequestBody Group group){
        groupService.deleteId(group.getId());
        return group.getId() + " deleted";
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        groupService.deleteAll();
        return "AllDeleted";
    }

}
