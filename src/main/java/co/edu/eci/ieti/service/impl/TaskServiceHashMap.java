package co.edu.eci.ieti.service.impl;

import co.edu.eci.ieti.data.Task;
import co.edu.eci.ieti.service.TaskService;
import co.edu.eci.ieti.util.IdGenerator;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskServiceHashMap implements TaskService {

    private Map<String, Task> tasks;

    public TaskServiceHashMap() {
        tasks = new HashMap<String, Task>();
    }

    @Override
    public Task create(Task task) {
        if (task.getId() == null) task.setId(IdGenerator.generateId(10, false, true));
        if (tasks.containsKey(task.getId())) return null;
        else {
            tasks.put(task.getId(), task);
            return task;
        }
    }

    @Override
    public Optional<Task> findById(String id) {
        return Optional.ofNullable(tasks.get(id));
    }

    @Override
    public List<Task> all() {
        return new ArrayList<Task>(tasks.values());
    }

    @Override
    public boolean deleteById(String id) {
        return tasks.remove(id) != null;
    }

    @Override
    public Task update(Task task, String id) {
        Task updateableTask = tasks.get(id);
        if (updateableTask != null) {
            if (!updateableTask.getName().equals(task.getName())) updateableTask.setName(task.getName());
            if (!updateableTask.getAssignedTo().equals(task.getAssignedTo())) updateableTask.setAssignedTo(task.getAssignedTo());
            if (!updateableTask.getDescription().equals(task.getDescription())) updateableTask.setDescription(task.getDescription());
            if (!updateableTask.getCreatedAt().equals(task.getCreatedAt())) updateableTask.setCreatedAt(task.getCreatedAt());
            if (!updateableTask.getStatus().equals(task.getStatus())) updateableTask.setStatus(task.getStatus());
            if (!updateableTask.getDueDate().equals(task.getDueDate())) updateableTask.setDueDate(task.getDueDate());
        }
        return updateableTask;
    }
}
