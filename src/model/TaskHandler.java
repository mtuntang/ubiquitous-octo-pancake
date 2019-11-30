package model;

import java.io.*;
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
        taskMap.put(name, new Task(name));
    }

    public void remove(String name) {
        taskMap.remove(name);
    }

    public Map getMap() {
        return taskMap;
   }
    public void save(TaskHandler taskHandler) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("save.dat"));
            out.writeObject(this);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //REQUIRES : save.txt exists in model package
    //EFFECTS : loads save data, makes a pointer to local TotalExpenses field
    public TaskHandler load(TaskHandler taskHandler) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("save.dat"));
            taskHandler = (TaskHandler) in.readObject();
            in.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            return taskHandler;
        } finally {
            return taskHandler;
        }
    }
}
