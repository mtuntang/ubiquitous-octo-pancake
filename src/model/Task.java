package model;

import java.io.Serializable;

public class Task implements Serializable {
    long startTime;
    long endTime;
    long avgTime;
    String name;
    int numberOfTimesRun;

    public Task(String name){
        this.name = name;
    }

    public void startTime(){
        startTime = System.nanoTime();
    }

    public void endTime(){

    }

    public void update(){

    }

    public void save(){

    }
}
