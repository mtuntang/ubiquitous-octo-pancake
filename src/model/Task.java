package model;

import java.io.*;
import java.util.Objects;

public class Task implements Serializable{
    private long startTime;
    private long endTime;
    private long avgTime;
    private String name;
    private int numberOfTimesRun;

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getAvgTime() {
        return avgTime;
    }

    public void setNumberOfTimesRun(int numberOfTimesRun) {
        this.numberOfTimesRun = numberOfTimesRun;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfTimesRun() {
        return numberOfTimesRun;
    }

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

    public long getElapsedTime(){
        return System.nanoTime() - startTime;
    }

    public void update(){
        avgTime = (endTime - startTime)/numberOfTimesRun;
    }

    public void load() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.name + ".dat"));
        Task load = (Task)in.readObject();
        loadFields(load);
    }

    public void loadFields(Task task) throws IOException{
        this.name = task.name;
        this.avgTime = task.avgTime;
        this.numberOfTimesRun = task.numberOfTimesRun;
    }

    public void save() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.name + ".dat"));
        out.writeObject(this);
        out.close();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return name.equals(task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
