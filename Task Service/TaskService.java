import java.util.ArrayList;

public class TaskService {

    private ArrayList<Task> taskList = new ArrayList<Task>();

    public boolean addTask(Task task) {

        for (Task existingTask : taskList) {
            if (existingTask.getTaskId().equals(task.getTaskId())) {
                return false;
            }
        }

        taskList.add(task);
        return true;
    }

    public boolean deleteTask(String taskId) {

        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getTaskId().equals(taskId)) {
                taskList.remove(i);
                return true;
            }
        }

        return false;
    }

    public boolean updateTaskName(String taskId, String name) {

        for (Task task : taskList) {
            if (task.getTaskId().equals(taskId)) {
                task.setName(name);
                return true;
            }
        }

        return false;
    }

    public boolean updateTaskDescription(String taskId, String description) {

        for (Task task : taskList) {
            if (task.getTaskId().equals(taskId)) {
                task.setDescription(description);
                return true;
            }
        }

        return false;
    }

    public Task getTask(String taskId) {

        for (Task task : taskList) {
            if (task.getTaskId().equals(taskId)) {
                return task;
            }
        }

        return null;
    }
}