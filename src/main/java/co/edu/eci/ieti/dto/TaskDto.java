package co.edu.eci.ieti.dto;

import co.edu.eci.ieti.util.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class TaskDto {

    public String name;
    public String description;
    public TaskStatus status;
    public String assignedTo;
    public Date dueDate;
    public Date createdAt;

}
