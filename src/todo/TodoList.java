package todo;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TodoList {
  private List<String> todoItems;
  Path filePath;

  public TodoList() {
    filePath = Paths.get("assets/todos.txt");
    readTheFile();
  }

  private void readTheFile() {
    try {
      todoItems = Files.readAllLines(filePath);

    } catch (IOException e) {
      System.out.println("could not read file");
    }

  }

  public void writeFile(String reason) {
    try {
      Files.write(filePath, todoItems);
    } catch (IOException e) {
      System.err.println("Could not update file while " + reason);
    }
  }

  public void listItems() {
    int counter = 0;
    for (String todoItem : todoItems) {
      counter++;
      System.err.println(counter + " - " + todoItem);
    }
    if (counter == 0) {
      System.err.println("No todos for today! :)");
    }
  }

  public void addItem(String itemToBeAdded) {
    todoItems.add(itemToBeAdded);
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
}
