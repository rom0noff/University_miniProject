package uz.university.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.university.miniproject.entity.model.Room;
import uz.university.miniproject.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("/api/room")
public class RoomController {
    //
    @Autowired
    private RoomService roomService;

    @PostMapping("/createInfo")
    public ResponseEntity createInfo(@RequestBody Room room){
        return ResponseEntity.ok(roomService.save(room));
    }
    @GetMapping("/showInfo")
    public ResponseEntity showInfo(){
        return ResponseEntity.ok(roomService.findAll());
    }
    @GetMapping("/showIdInfo")
    public ResponseEntity showByIdInfo(@RequestBody Room room){
        return ResponseEntity.ok(roomService.findById(room.getId()));
    }
    @PutMapping("/changeInfo")
    public ResponseEntity changeInfo(@RequestBody Room room){
        List<Room> seeInfo = roomService.findAll();
        String message = "";
        for (int i = 0; i < seeInfo.size(); i++) {
            if(room.getId().equals(seeInfo.get(i).getId())){
                if(room.getName() != null){
                    seeInfo.get(i).setName(room.getName());
                }else {
                    seeInfo.get(i).setName(seeInfo.get(i).getName());
                }
                if(room.getCapacity() != null){
                    seeInfo.get(i).setCapacity(room.getCapacity());
                }else {
                    seeInfo.get(i).setCapacity(seeInfo.get(i).getCapacity());
                }
                room = seeInfo.get(i);
                roomService.save(room);
                return ResponseEntity.ok(room);
            }else {
                message = "not";
            }
        }
        if (message.equals("not")){
            return ResponseEntity.ok('"' + "id" + '"' + ":"  + '"' + room.getId() + '"' + " information not found");
        }
        return ResponseEntity.ok(room);
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        roomService.deleteAll();
        return "AllDeleted";
    }
    @DeleteMapping("/deleteById")
    public String deleteById(@RequestBody Room room){
        roomService.deleteById(room.getId());
        return room.getId() + " deleted";
    }
}
