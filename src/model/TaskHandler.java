package model;

import java.util.ArrayList;
import java.util.List;

public class TaskHandler {

    private List<Task> taskList;

    public TaskHandler() {
        taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }
    public void removeTask(Task task) {
        for (Task t : taskList){
            if (t.name.equals(task.name)){
                taskList.remove(t)
            }
        }
        if(task.name.e)
    }
}
