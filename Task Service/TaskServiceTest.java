import static org.junit.Assert.*;

import org.junit.Test;

public class TaskServiceTest {

    @Test
    public void testAddTaskSuccessfully() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Task Name", "Task description");

        assertTrue(service.addTask(task));
        assertEquals(task, service.getTask("12345"));
    }

    @Test
    public void testAddDuplicateTaskFails() {
        TaskService service = new TaskService();

        Task taskOne = new Task("12345", "Task One", "First description");
        Task taskTwo = new Task("12345", "Task Two", "Second description");

        assertTrue(service.addTask(taskOne));
        assertFalse(service.addTask(taskTwo));
    }

    @Test
    public void testDeleteTaskSuccessfully() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Task Name", "Task description");

        service.addTask(task);

        assertTrue(service.deleteTask("12345"));
        assertNull(service.getTask("12345"));
    }

    @Test
    public void testDeleteTaskFailsWhenTaskDoesNotExist() {
        TaskService service = new TaskService();

        assertFalse(service.deleteTask("99999"));
    }

    @Test
    public void testUpdateTaskNameSuccessfully() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Old Name", "Task description");

        service.addTask(task);

        assertTrue(service.updateTaskName("12345", "New Name"));
        assertEquals("New Name", service.getTask("12345").getName());
    }

    @Test
    public void testUpdateTaskDescriptionSuccessfully() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Task Name", "Old description");

        service.addTask(task);

        assertTrue(service.updateTaskDescription("12345", "New description"));
        assertEquals("New description", service.getTask("12345").getDescription());
    }

    @Test
    public void testUpdateNameFailsWhenTaskDoesNotExist() {
        TaskService service = new TaskService();

        assertFalse(service.updateTaskName("99999", "New Name"));
    }

    @Test
    public void testUpdateDescriptionFailsWhenTaskDoesNotExist() {
        TaskService service = new TaskService();

        assertFalse(service.updateTaskDescription("99999", "New description"));
    }

    @Test
    public void testUpdateNameFailsWhenNameIsTooLong() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Task Name", "Task description");

        service.addTask(task);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskName("12345", "This name is way too long");
        });
    }

    @Test
    public void testUpdateDescriptionFailsWhenDescriptionIsTooLong() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Task Name", "Task description");

        service.addTask(task);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskDescription("12345", "This description is longer than fifty characters and should fail");
        });
    }

    @Test
    public void testUpdateNameFailsWhenNameIsNull() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Task Name", "Task description");

        service.addTask(task);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskName("12345", null);
        });
    }

    @Test
    public void testUpdateDescriptionFailsWhenDescriptionIsNull() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Task Name", "Task description");

        service.addTask(task);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateTaskDescription("12345", null);
        });
    }
}