//Command Line Todo application
//    =============================
//
//    Command line arguments:
//    -l   Lists all the tasks
//    -a   Adds a new task
//    -r   Removes an task
//    -c   Completes an task


package todo;

public class ArgumentHandling {

  public void printUsageInformation(String[] args){
    if (args[0].isEmpty()){
      System.out.println("no args");
    }
  }
}
