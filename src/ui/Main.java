package ui;
import model.TaskHandler;

import java.util.Scanner;

public class Main {
    static TaskHandler taskHandler = new TaskHandler();

    public static void main(String[] args) {
        welcome();
        while (true) {

        }
    }

    private static void welcome() {
        System.out.println("Welcome to the task handler");
        System.out.println("Actions:");
        System.out.println("1 - Add a new task");
        System.out.println("2 - Remove a task");
        System.out.println("3 - Run a task");
        System.out.println();
    }

    public static void queryTask() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Name your task: ");
        String taskName = myObj.nextLine();  // Read user input
        taskHandler.addTask(taskname);
    }

    public static void queryTask() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Name your task: ");
        String taskName = myObj.nextLine();  // Read user input
        taskHandler.addTask(taskname);
    }

    public static void removeTask() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Which task would you like to remove?: ");
        String taskName = myObj.nextLine();  // Read user input
        taskHandler.removeTask(taskname);
    }
}
