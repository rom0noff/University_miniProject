package uz.university.miniproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.university.miniproject.entity.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    //
    User findByUserName(String userUser );
    boolean existsByUserName(String userName);
}
