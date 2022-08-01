package uz.university.miniproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.university.miniproject.entity.model.PayType;

@Repository
public interface PayTypeRepo extends CrudRepository<PayType, Long> {
}
