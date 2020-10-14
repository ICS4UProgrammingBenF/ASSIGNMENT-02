//import necessary libraries
import java.io.*;
import java.util.*;

/**
* This application determines whether students passed their class or not.
* And then outputs it to a txt file
*
* @author  Ben Falsetto
* @version 1.0
* @since   2020-09-29
*/
public class PassFail {
  
  /**
    * Main section of code.
  */
  public static void main(String[] args) {
    
    //try to read the text file
    try {
      System.out.println("Attempting to parse file");
      
      //declare the strings necessary for output
      String outputString = "";
      
      //read the file
      File myObj = new File("DATA12.txt");
      Scanner scanner = new Scanner(myObj);
      
      //update the console with progress
      System.out.println("Success!");
      System.out.println("Calculating marks");
      
      while (scanner.hasNextLine() == true) {
        //get the next line
        String line = scanner.nextLine();
        
        //declare the numpassed variable
        int numPassed = 0;
        int numFailed = 0;
        
        // split the line according to " "
        String[] stringArray = line.split("\\s+");
        
        //convert each weight from string to float and assign to variable
        float weightTest = Float.parseFloat(stringArray[0]);
        float weightAssign = Float.parseFloat(stringArray[1]);
        float weightProj = Float.parseFloat(stringArray[2]);
        float weightQuiz = Float.parseFloat(stringArray[3]);
        
        //get num students
        int numStudents = Integer.parseInt(scanner.nextLine());
        
        //loop through each student and get their marks
        for (int i = 0; i < numStudents; i++) {
          String lineMarks = scanner.nextLine();
          String[] marksArray = lineMarks.split("\\s+");
          
          //get marks for a student
          float markTest = Float.parseFloat(marksArray[0]);
          float markAssign = Float.parseFloat(marksArray[1]);
          float markProj = Float.parseFloat(marksArray[2]);
          float markQuiz = Float.parseFloat(marksArray[3]);
          
          //calculate the marks of the student
          float finalTest = markTest * (weightTest / 100);
          float finalAssign = markAssign * (weightAssign / 100);
          float finalProj = markProj * (weightProj / 100);
          float finalQuiz = markQuiz * (weightQuiz / 100);
          
          //continued from above
          float average = finalTest + finalAssign + finalProj + finalQuiz;
          
          //determine pass/fail
          if (average >= 50) {
            numPassed++;
          } else  {
            numFailed++;
          }
        }
        //write to output string
        outputString += "Students passed: " + numPassed + "\r\n";
        outputString += "Students failed: " + numFailed + "\r\n";
      }
      //write the output string to the output file
      FileWriter fileWriter = new FileWriter("OUTPUT.txt");
      fileWriter.write(outputString);
      fileWriter.close();
      
      System.out.println("Done!");
      System.out.println("You can find the results in OUTPUT.txt");
      
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}