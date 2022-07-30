package uz.university.miniproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.university.miniproject.entity.model.Payment;

@Repository
public interface PaymentRepo extends CrudRepository<Payment, Long> {
}
