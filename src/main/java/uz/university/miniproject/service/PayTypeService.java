package uz.university.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.university.miniproject.entity.model.PayType;
import uz.university.miniproject.entity.model.Room;
import uz.university.miniproject.repository.PayTypeRepo;
import uz.university.miniproject.repository.PaymentRepo;
import uz.university.miniproject.repository.RoomRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PayTypeService {
    //
    @Autowired
    private PayTypeRepo payTypeRepo;

    public PayType save(PayType payType){
        return payTypeRepo.save(payType);
    }
    public List<PayType> findAll(){
        return (List<PayType>) payTypeRepo.findAll();
    }
    public Optional<PayType> findById(Long id){
        return payTypeRepo.findById(id);
    }
    public void deleteAll(){
        payTypeRepo.deleteAll();
    }
    public void deleteById(Long id){
        payTypeRepo.deleteById(id);
    }
}
