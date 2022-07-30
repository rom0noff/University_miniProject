package uz.university.miniproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.university.miniproject.entity.model.Status;

@Repository
public interface StatusRepo extends CrudRepository<Status, Long> {
}
