package co.edu.eci.ieti.controller;

import co.edu.eci.ieti.data.Task;
import co.edu.eci.ieti.dto.TaskDto;
import co.edu.eci.ieti.mapper.TaskMapper;
import co.edu.eci.ieti.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        var tasks = taskService.all();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") String id) {
        var taskOptional = taskService.findById(id);
        return new ResponseEntity<>(taskOptional.orElse(new Task()), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody TaskDto taskDto) {
        var createdTask = taskService.create(TaskMapper.toTask(taskDto));
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TaskDto taskDto, @PathVariable String id) {
        var updatedTask = taskService.update(TaskMapper.toTask(taskDto), id);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        var deleted = taskService.deleteById(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

}
