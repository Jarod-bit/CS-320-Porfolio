import static org.junit.Assert.*;

import org.junit.Test;

public class TaskTest {

    @Test
    public void testTaskCreatedSuccessfully() {
        Task task = new Task("1234567890", "Task Name", "Task description");

        assertEquals("1234567890", task.getTaskId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task description", task.getDescription());
    }

    @Test
    public void testTaskIdCannotBeLongerThanTenCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Task Name", "Task description");
        });
    }

    @Test
    public void testTaskIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Task Name", "Task description");
        });
    }

    @Test
    public void testNameCannotBeLongerThanTwentyCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "This name is way too long", "Task description");
        });
    }

    @Test
    public void testNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", null, "Task description");
        });
    }

    @Test
    public void testDescriptionCannotBeLongerThanFiftyCharacters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Task Name", "This description is longer than fifty characters and should fail");
        });
    }

    @Test
    public void testDescriptionCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Task Name", null);
        });
    }

    @Test
    public void testNameCanBeUpdated() {
        Task task = new Task("12345", "Old Name", "Task description");

        task.setName("New Name");

        assertEquals("New Name", task.getName());
    }

    @Test
    public void testDescriptionCanBeUpdated() {
        Task task = new Task("12345", "Task Name", "Old description");

        task.setDescription("New description");

        assertEquals("New description", task.getDescription());
    }

    @Test
    public void testSetNameCannotBeNull() {
        Task task = new Task("12345", "Task Name", "Task description");

        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
    }

    @Test
    public void testSetDescriptionCannotBeNull() {
        Task task = new Task("12345", "Task Name", "Task description");

        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });
    }
}