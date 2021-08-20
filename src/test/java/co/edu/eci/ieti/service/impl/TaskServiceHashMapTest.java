package co.edu.eci.ieti.service.impl;

import co.edu.eci.ieti.data.Task;
import co.edu.eci.ieti.service.TaskService;
import co.edu.eci.ieti.util.TaskStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceHashMapTest {

    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskServiceHashMap();
        mockData();
    }

    private void mockData() {
        taskService.create(new Task(
            "1234",
            "Reparación PC",
            "Se debe reparar el PC dañado #13",
            TaskStatus.REVIEW,
            "Eduard Arias",
            new Date(2021, 11, 1),
            new Date()
        ));
    }

    @Test
    public void shouldCreateTask() {
        try {
            assertEquals(taskService.create(new Task("123", null, null, TaskStatus.TODO, null, new Date(), new Date())),
                    new Task("123", null, null, TaskStatus.TODO, null, new Date(), new Date()));
            assertNull(taskService.create(new Task("1234", null, null, TaskStatus.TODO, null, new Date(), new Date())));
            assertEquals(taskService.all().size(), 2);
        } catch (Exception ex) {
            fail("An exception has ocurred: "+ex.getLocalizedMessage());
        }
    }

    @Test
    public void shouldFindTaskById() {
        try {
            assertEquals(taskService.findById("1234").orElseThrow(), new Task(
                    "1234",
                    "Reparación PC",
                    "Se debe reparar el PC dañado #13",
                    TaskStatus.REVIEW,
                    "Eduard Arias",
                    new Date(2021, 11, 1),
                    new Date()
            ));
        } catch (Exception ex) {
            fail("An exception has ocurred: "+ex.getLocalizedMessage());
        }
    }

    @Test
    public void shouldDeleteTaskById() {
        try {
            assertFalse(taskService.deleteById("asdasd"));
            assertTrue(taskService.deleteById("1234"));
            assertThrows(NoSuchElementException.class, () -> taskService.findById("1234").get());
        } catch (Exception ex) {
            fail("An exception has ocurred: "+ex.getLocalizedMessage());
        }
    }

    @Test
    public void shouldUpdateTask() {
        try {

        } catch (Exception ex) {
            fail("An exception has ocurred: "+ex.getLocalizedMessage());
        }
    }
}