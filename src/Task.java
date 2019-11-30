import java.util.Observable;

public class Task extends Observable {
    private String taskName;
    private int average;
    private int timesDone;

    public Task(String name) {
        taskName = name;
    }
}
