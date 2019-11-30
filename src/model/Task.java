package model;

import java.io.*;

public class Task implements Serializable {
    private long startTime;
    private long endTime;
    private long avgTime;
    private String name;
    private int numberOfTimesRun;

    public Task(String name){
        this.name = name;
    }

    public void startTime(){
        startTime = System.nanoTime();
    }

    public void endTime(){
        endTime = System.nanoTime();
        numberOfTimesRun++;
    }

    public void update(){
        avgTime = (endTime - startTime)/numberOfTimesRun;
    }

    public void load() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("stub.dat"));
        Task load = (Task)in.readObject();
        loadFields(load);
    }

    public void loadFields(Task task) throws IOException{
        this.name = task.name;
        this.avgTime = task.avgTime;
        this.numberOfTimesRun = task.numberOfTimesRun;
    }

    public void save() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("stub.dat"));
        out.writeObject(this);
        out.close();
    }
}
