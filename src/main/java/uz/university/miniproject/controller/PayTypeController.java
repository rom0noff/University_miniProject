package uz.university.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.university.miniproject.entity.model.PayType;
import uz.university.miniproject.entity.model.Room;
import uz.university.miniproject.service.PayTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/payType")
public class PayTypeController {
    //
    @Autowired
    private PayTypeService payTypeService;

    @PostMapping("/createInfo")
    public ResponseEntity createInfo(@RequestBody PayType payType){
        return ResponseEntity.ok(payTypeService.save(payType));
    }
    @GetMapping("/showInfo")
    public ResponseEntity showInfo(){
        return ResponseEntity.ok(payTypeService.findAll());
    }
    @GetMapping("/showIdInfo")
    public ResponseEntity showByIdInfo(@RequestBody PayType payType){
        return ResponseEntity.ok(payTypeService.findById(payType.getId()));
    }
    @PutMapping("/changeInfo")
    public ResponseEntity changeInfo(@RequestBody PayType payType){
        List<PayType> seeInfo = payTypeService.findAll();
        String message = "";
        for (int i = 0; i < seeInfo.size(); i++) {
            if(payType.getId().equals(seeInfo.get(i).getId())){
                if(payType.getName() != null){
                    seeInfo.get(i).setName(payType.getName());
                }else {
                    seeInfo.get(i).setName(seeInfo.get(i).getName());
                }
                payType = seeInfo.get(i);
                payTypeService.save(payType);
                return ResponseEntity.ok(payType);
            }else {
                message = "not";
            }
        }
        if(message.equals("not")){
            return ResponseEntity.ok('"' + "id" + '"' + ":"  + '"' + payType.getId() + '"' + " information not found");
        }
        return ResponseEntity.ok(payType);
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        payTypeService.deleteAll();
        return "AllDeleted";
    }
    @DeleteMapping("/deleteById")
    public String deleteById(@RequestBody Room room){
        payTypeService.deleteById(room.getId());
        return room.getId() + " deleted";
    }
}
