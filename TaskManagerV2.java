//TaskManagerV2.java - Recreated by: ImmortalScar17#3644
//Imports
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class TaskManagerV2 {
    static void endCommand(String taskname){
        Scanner scan = new Scanner(System.in);
        char[] animationChars = new char[] { '|', '/', '-', '\\' };
        if (taskname.toLowerCase().equals("end")){
            System.out.println("\n");
            for (int i = 0; i <= 100; i++) {
                System.out.print("Ending Task Manager... " + i + "% " + animationChars[i % 4] + "\r");
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    scan.close();
                    e.printStackTrace();
                }
            }
            System.out.println("\nTask Manager has been successfully terminated!\nNo tasklist was created.");
            scan.close();
            System.exit(0);
        }
    }
    public static void main(String[] args)throws Exception {
        try (Scanner scan = new Scanner(System.in)){
            int end = 5;
            int taskNum = 0;
            System.out.println(
                "\nWelcome to Task Manager BETA!\nWhile entering your tasks, type \"end\" to end task creation and move on.");
            //Name input
            System.out.print("Enter Checklist Name;\n=> ");
            String checklistFileName = scan.nextLine();
            //Start of Task
            while (end == 5){
                System.out.print("Enter name of task;\n=> ");
                String taskname = scan.nextLine();
                endCommand(taskname);
                System.out.print("Enter the description. [If none, type \"none\" to go to next task.]\n=>");
                String taskDescription = scan.nextLine();
                endCommand(taskDescription);
                if (taskDescription.toLowerCase().equals("none")){
                    taskDescription = "\n";
                }
                System.out.println(taskname + " successfully entered!");
                taskNum++;
                if (taskNum == 1){
                    try {
                        FileWriter fileWrite = new FileWriter(checklistFileName + "'s Tasklist.txt");
                        fileWrite.write(checklistFileName + "'s Tasklist:\n\nTask"+ taskNum +": " + taskname + "\nDescription: " + taskDescription);
                        fileWrite.close();
                    } catch (IOException e) {
                        System.out.println("There was an error creating your tasklist file.");
                        scan.close();
                        e.printStackTrace();
                    }
                }
                else{
                    try {
                        FileWriter fileWrite = new FileWriter(checklistFileName + "'s Tasklist.txt", true);
                        fileWrite.write("\nTask"+ taskNum +": " + taskname + "\nDescription: " + taskDescription);
                        fileWrite.close();
                    } catch (IOException e) {
                        System.out.println("There was an error editing your tasklist file.");
                        scan.close();
                        e.printStackTrace();
                    }
                }
            }
            scan.close();
            System.exit(0);
        }
    }
}