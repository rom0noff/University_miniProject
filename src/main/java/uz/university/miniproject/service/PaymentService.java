package uz.university.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.university.miniproject.entity.model.Payment;
import uz.university.miniproject.repository.PaymentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    //
    @Autowired
    PaymentRepo paymentRepo;

    public Payment save(Payment payment){
        return paymentRepo.save(payment);
    }
    public List<Payment> findAll(){
        return (List<Payment>) paymentRepo.findAll();
    }
    public Optional<Payment> findById(Long id){
        return paymentRepo.findById(id);
    }
    public void deleteAll(){
       paymentRepo.deleteAll();
    }
    public void deleteById(Long id){
        paymentRepo.deleteById(id);
    }
}
