package co.edu.eci.ieti.mapper;

import co.edu.eci.ieti.data.Task;
import co.edu.eci.ieti.dto.TaskDto;

public class TaskMapper {

    public static Task toTask(TaskDto taskDto) {
        var newTask = new Task();
        newTask.setName(taskDto.getName());
        newTask.setDescription(taskDto.getDescription());
        newTask.setStatus(taskDto.getStatus());
        newTask.setAssignedTo(taskDto.getAssignedTo());
        newTask.setDueDate(taskDto.getDueDate());
        newTask.setCreatedAt(taskDto.getCreatedAt());

        return newTask;
    }

    public static TaskDto toTaskDto(Task task) {
        var newTaskDto = new TaskDto();
        newTaskDto.setName(task.getName());
        newTaskDto.setDescription(task.getDescription());
        newTaskDto.setStatus(task.getStatus());
        newTaskDto.setAssignedTo(task.getAssignedTo());
        newTaskDto.setDueDate(task.getDueDate());
        newTaskDto.setCreatedAt(task.getCreatedAt());

        return newTaskDto;
    }

}
