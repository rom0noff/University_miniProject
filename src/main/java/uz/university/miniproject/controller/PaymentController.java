package uz.university.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.university.miniproject.entity.model.Payment;
import uz.university.miniproject.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    //
    @Autowired
    private PaymentService paymentService;
    @PostMapping("/createInfo")
    public ResponseEntity createInfo(@RequestBody Payment payment){
        return ResponseEntity.ok(paymentService.save(payment));
    }
    @GetMapping("/showInfo")
    public ResponseEntity showInfo(){
        return ResponseEntity.ok(paymentService.findAll());
    }
    @GetMapping("/showIdInfo")
    public ResponseEntity showByIdInfo(@RequestBody Payment payment){
        return ResponseEntity.ok(paymentService.findById(payment.getId()));
    }
    @PutMapping("/changeInfo")
    public ResponseEntity changeInfo(@RequestBody Payment payment){
        List<Payment> seeInfo = paymentService.findAll();
        String message = "";
        for (int i = 0; i < seeInfo.size(); i++) {
            if (payment.getId().equals(seeInfo.get(i).getId())){
                if(payment.getDescription() != null){
                    seeInfo.get(i).setDescription(payment.getDescription());
                }else {
                    seeInfo.get(i).setDescription(seeInfo.get(i).getDescription());
                }
                if(payment.getSum() != null){
                    seeInfo.get(i).setSum(payment.getSum());
                }else {
                    seeInfo.get(i).setSum(seeInfo.get(i).getSum());
                }
                payment = seeInfo.get(i);
                paymentService.save(payment);
                return ResponseEntity.ok(payment);
            }else {
                message = "not";
            }
        }
        if(message.equals("not")){
            return ResponseEntity.ok('"' + "id" + '"' + ":"  + '"' + payment.getId() + '"' + " information not found");
        }
        return ResponseEntity.ok(payment);
    }
    @DeleteMapping("/deleteAll")
    public String deleteAllInfo(){
        paymentService.deleteAll();
        return "AllDeleted";
    }
    @DeleteMapping("/deleteById")
    public String deleteById(@RequestBody Payment payment){
        paymentService.deleteById(payment.getId());
        return payment.getId() + " deleted";
    }
}
