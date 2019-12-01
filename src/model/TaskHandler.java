package model;

import java.io.*;
import java.util.*;

public class TaskHandler {

    private HashMap<String, Task> taskMap;
    private boolean run = false;

    public TaskHandler() {
        taskMap = new HashMap<>();
    }

    public void addTask(String name) {
        taskMap.put(name, new Task(name));
    }

    public void remove(String name) {
        taskMap.remove(name);
    }

    public HashMap<String, Task> getMap() {
        return taskMap;
   }
    public void save() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("save.dat"));
            out.writeObject(this);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void clearData() {
        taskMap = new HashMap<String, Task>();
        save();
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

    public void startTask(String name) {
        Task currentTask = taskMap.get(name);
        currentTask.startTime();
    }
    public boolean updateTime(String name) {
        Task currentTask = taskMap.get(name);
        if (currentTask.getAvgTime() > currentTask.getElapsedTime()) {
                return true;
        } else {
            return false;
        }
    }

    public void endTask(String name) {
        Task currentTask = taskMap.get(name);
        currentTask.endTime();
        currentTask.update();

    }
}
