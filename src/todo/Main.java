package todo;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
  public static void main(String[] args) throws IOException {
    //System.out.println(args.length);
    TodoList todoList = new TodoList();


    if (args.length == 0) {
      System.err.println("Command Line Todo application\n" +
          "=============================\n" +
          "\n" +
          "Command line arguments:\n" +
          "    -l   Lists all the tasks\n" +
          "    -a   Adds a new task\n" +
          "    -r   Removes an task\n" +
          "    -c   Completes an task");
    } else if (args.length >= 1) {
      if (args[0].equals("-l")) {
        todoList.listItems();
      } else if (args[0].equals("-a")) {
        if (args.length == 1) {
          System.err.println("Unable to add: no task provided");
        } else {
          todoList.addItem(args[1]);
        }
      } else if (args[0].equals("-r")) {
        if (args.length == 1) {
          System.err.println("Unable to remove: no index provided");
          return;
        } else {
          try {
            Integer index = Integer.parseInt(args[1]);
            todoList.removeItem(index);
          } catch (NumberFormatException e) {
            System.err.println("Unable to remove: index is not a number");
          }
        }
      } else if (args[0].equals("-c")) {
        System.out.println("c");
      } else {
        System.err.println("Unsupported argument");
        printUsage();
      }
    }
  }

  public static void printUsage() {
    System.err.println("Command Line Todo application\n" +
        "=============================\n" +
        "\n" +
        "Command line arguments:\n" +
        "    -l   Lists all the tasks\n" +
        "    -a   Adds a new task\n" +
        "    -r   Removes an task\n" +
        "    -c   Completes an task");
  }
}