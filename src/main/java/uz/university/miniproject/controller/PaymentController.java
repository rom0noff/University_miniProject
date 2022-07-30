package uz.university.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.university.miniproject.entity.model.Payment;
import uz.university.miniproject.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    //
    @Autowired
    PaymentService paymentService;
    @PostMapping("/createInfo")
    public ResponseEntity createInfo(@RequestBody Payment payment){
        return ResponseEntity.ok(payment);
    }
    @GetMapping("/showInfo")
    public ResponseEntity showInfo(){
        return ResponseEntity.ok(paymentService.findAll());
    }
//    @GetMapping("/showIdInfo")
//    public ResponseEntity showByIdInfo(@RequestBody Payment payment){
//
//    }
}
