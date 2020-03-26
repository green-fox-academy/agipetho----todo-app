package todo;

public class TodoItem {

  String todo;
  boolean isCompleted;

  public TodoItem(String todo, boolean isCompleted) {
    this.todo = todo;
    this.isCompleted = isCompleted;
  }

  public String getTodoItem() {
    return todo;
  }

  public boolean isCompleted() {
    return isCompleted;
  }

  public void check() {
    isCompleted = true;
  }
}
