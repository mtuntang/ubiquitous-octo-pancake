package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskHandler {

    private Map taskMap;

    public TaskHandler() {
        taskMap = new HashMap<String, Task>();
    }

    public void addTask(String name) {
        taskMap.put(new Task(name));
    }

    public Map getMap() {
        return taskMap;
   }
}
