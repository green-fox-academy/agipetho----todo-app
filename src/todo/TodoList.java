package todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TodoList {
  private List<TodoItem> todoItems;
  Path filePath;

  public TodoList() {
    todoItems = new ArrayList<TodoItem>();
    filePath = Paths.get("assets/todos.txt");
    readTheFile();
  }

  private void readTheFile() {
    try {
      List<String> lines = Files.readAllLines(filePath);
      for (String line : lines) {
        // TODO: add logic to parse new line format which includen completion
        // e.g.: c|have lunch
        //       u|buy bread
        String[] parsedLine = line.split(";");
        TodoItem toDoItem = new TodoItem(parsedLine[1], (parsedLine[0].equals("c") ? true : false));
        todoItems.add(toDoItem);
      }

    } catch (IOException e) {
      System.out.println("could not read file");
    }
  }

  public void writeFile(String reason) {
    try {
      List<String> lines = new ArrayList<>();
      for (TodoItem todoItem : todoItems) {
        lines.add(((todoItem.isCompleted()) ? "c" : "u") + ";" + todoItem.getTodoItem());
      }
      Files.write(filePath, lines);
    } catch (IOException e) {
      System.err.println("Could not update file while " + reason);
    }
  }

  public void listItems() {
    int counter = 0;
    for (TodoItem todoItem : todoItems) {
      counter++;
      System.err.println(counter + " - [" + ((todoItem.isCompleted() ? "x" : " ")) + "] " + todoItem.getTodoItem());
    }
    if (counter == 0) {
      System.err.println("No todos for today! :)");
    }
  }

  public void addItem(String itemToBeAdded) {
    TodoItem toDoItem = new TodoItem(itemToBeAdded, false);
    todoItems.add(toDoItem);
    writeFile("adding");
  }

  public void removeItem(int index) {
    if (todoItems.size() < index) {
      System.err.println("Unable to remove: index is out of bound");
      return;
    }
    todoItems.remove(index - 1);
    writeFile("removing");
  }

  public void checkItem(int index) {
    if (todoItems.size() < index) {
      System.err.println("Unable to check: index is out of bound");
      return;
    }
    todoItems.get(index - 1).check();
    writeFile("checking");
  }
}
