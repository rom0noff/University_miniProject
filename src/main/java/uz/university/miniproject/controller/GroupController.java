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
        String message = "";
        for (int i = 0; i < seeInfo.size(); i++) {
            if (group.getId().equals(seeInfo.get(i).getId())) {
                if (group.getName() != null) {
                    seeInfo.get(i).setName(group.getName());
                } else {
                    seeInfo.get(i).setName(seeInfo.get(i).getName());
                }
                if(group.getStart_date() != null){
                    seeInfo.get(i).setStart_date(group.getStart_date());
                }else {
                    seeInfo.get(i).setStart_date(seeInfo.get(i).getStart_date());
                }
                if(group.getEnd_date() != null){
                    seeInfo.get(i).setEnd_date(group.getEnd_date());
                }else {
                    seeInfo.get(i).setEnd_date(seeInfo.get(i).getEnd_date());
                }
                group = seeInfo.get(i);
                groupService.save(group);
                return ResponseEntity.ok(group);
            }
            else {
                message = "not";
            }
        }
        if(message.equals("not")){
            return ResponseEntity.ok('"' + "id" + '"' + ":"  + '"' + group.getId() + '"' + " information not found");
        }
        return ResponseEntity.ok(group);
    }
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable Long id){
        groupService.deleteId(id);
        return id + " deleted";
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        groupService.deleteAll();
        return "AllDeleted";
    }

}
