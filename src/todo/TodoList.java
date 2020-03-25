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

  public TodoList(List<String> todoItems) {
    this.todoItems = todoItems;
  }

  public TodoList() {

  }
  private List<String> readTheFile() {
    String pathTodosFile = "assets/todos.txt";
    Path filepath = Paths.get("assets/todos.txt");
    try {
      List<String> todoItems = Files.readAllLines(filepath);
      List<String> todoItemsStored = new ArrayList<>();
      for (String todoItem : todoItems) {
        todoItemsStored.add(todoItem);
      }
      return todoItemsStored;
    } catch (IOException e) {
      System.out.println("could not read file");
    }
    return null;
  }

  public void listItems() {
    List<String> filecontent = readTheFile();
    int counter = 0;
    for (String todoItem : filecontent) {
      counter++;
      System.out.println(counter + " - " + todoItem);
    }
    if (counter == 0) {
      System.out.println("No todos for today! :)");
    }
  }

  public void addItem(String itemToBeAdded) throws IOException {
    List<String> filecontent = readTheFile();
    filecontent.add(itemToBeAdded);
    Path path = Paths.get("assets/todos.txt");
    Files.write(path, filecontent);
  }

  public void removeItem(int index) throws IOException {
    String pathTodosFile = "assets/todos.txt";
    Path filepath = Paths.get("assets/todos.txt");
    List<String> filecontent = readTheFile();
    if (filecontent.size() <= index) {
      System.out.println("Unable to remove: index is out of bound");
      return;
    }
    for (String todoItem : filecontent) {
      filecontent.remove(index - 1);
      Files.write(filepath, filecontent);
    }
  }
}
