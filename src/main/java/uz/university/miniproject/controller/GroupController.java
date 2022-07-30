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
        for (int i = 0; i < seeInfo.size(); i++) {
            if (group.getId().equals(seeInfo.get(i).getId())){
                if(group.getName() != null){
                    seeInfo.get(i).setName(group.getName());
                }else {
                    seeInfo.get(i).setName(seeInfo.get(i).getName());
                }
                group = seeInfo.get(i);
                groupService.save(group);
            }
        }
        return ResponseEntity.ok(group);
    }
    @DeleteMapping("/deleteById")
    public void deleteById(@RequestBody Group group){
        groupService.deleteId(group.getId());
    }
    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        groupService.deleteAll();
    }

}
