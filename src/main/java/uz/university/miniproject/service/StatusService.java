package uz.university.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.university.miniproject.entity.model.Status;
import uz.university.miniproject.repository.StatusRepo;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    //
    @Autowired
    private StatusRepo statusRepo;

    public Status save(Status status){
        return statusRepo.save(status);
    }
    public List<Status> findAll(){
        return (List<Status>) statusRepo.findAll();
    }
    public Optional<Status> findById(Long id){
        return statusRepo.findById(id);
    }
    public void deleteAll(){
        statusRepo.deleteAll();
    }
    public void deleteById(Long id){
        statusRepo.deleteById(id);
    }
}
