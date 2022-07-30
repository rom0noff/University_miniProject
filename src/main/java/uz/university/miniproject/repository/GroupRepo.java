package uz.university.miniproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.university.miniproject.entity.model.Group;

@Repository
public interface GroupRepo extends CrudRepository<Group,Long> {
}
