package uz.university.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.university.miniproject.entity.model.Group;
import uz.university.miniproject.repository.GroupRepo;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    //
    @Autowired
    private GroupRepo groupRepo;

    public Group save(Group group){
        return groupRepo.save(group);
    }
    public List<Group> findAll(){
        return (List<Group>) groupRepo.findAll();
    }
    public Optional<Group> findById(Long id){
        return groupRepo.findById(id);
    }
    public void deleteAll(){
        groupRepo.deleteAll();
    }
    public void deleteId(Long id){
        groupRepo.deleteById(id);
    }
}
