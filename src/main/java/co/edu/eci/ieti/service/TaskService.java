package co.edu.eci.ieti.service;

import co.edu.eci.ieti.data.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task create(Task task );
    Optional<Task> findById(String id );
    List<Task> all();
    boolean deleteById( String id );
    Task update( Task task, String id );

}
