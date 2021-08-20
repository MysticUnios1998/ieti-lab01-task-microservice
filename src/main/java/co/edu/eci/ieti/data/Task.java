package co.edu.eci.ieti.data;

import co.edu.eci.ieti.util.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Task {

    public String id;
    public String name;
    public String description;
    public TaskStatus status;
    public String assignedTo;
    public Date dueDate;
    public Date createdAt;

    @Override
    public boolean equals(Object obj) {
        return equals((Task) obj);
    }

    public boolean equals(Task task) {
        return this.id == task.getId();
    }

}
