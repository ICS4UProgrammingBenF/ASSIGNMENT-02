//import necessary libraries
import java.io.*;
import java.util.*;
//import java.util.Array;
// java.util.Scanner;

/**
 * Class PassFail
 */
public class PassFail {
  public static void main(String[] args) {
    
    //try to read the text file
    try {
      File myObj = new File("DATA10.txt");
      
      Scanner scanner = new Scanner(myObj);
      
      String outputFileName = "OUTPUT.txt";
      
      while (scanner.hasNextLine() == true) {
        System.out.println("New Class");
        //get the next line
        String line = scanner.nextLine();
        
        int numPassed = 0;
        
        // split the line according to " "
        String[] stringArray = line.split("\\s+");
        
        //convert each weight from string to float and assign to variable
        float wTest = Float.parseFloat(stringArray[0]);
        float wAssign = Float.parseFloat(stringArray[1]);
        float wProj = Float.parseFloat(stringArray[2]);
        float wQuiz = Float.parseFloat(stringArray[3]);
        
        //get num students
        int numStudents = Integer.parseInt(scanner.nextLine());
        System.out.println(numStudents);
        
        for (int i = 0; i < numStudents; i++) {
          String lineMarks = scanner.nextLine();
          String[] marksArray = lineMarks.split("\\s+");
          
          
          //System.out.println ("marksArray length = " + marksArray.length);
          
          //get marks for a student
          float mTest = Float.parseFloat(marksArray[0]);
          float mAssign = Float.parseFloat(marksArray[1]);
          float mProj = Float.parseFloat(marksArray[2]);
          float mQuiz = Float.parseFloat(marksArray[3]);
          
          float finalTest = mTest * (wTest / 100);
          float finalAssign = mAssign * (wAssign / 100);
          float finalProj = mProj * (wProj / 100);
          float finalQuiz = mQuiz * (wQuiz / 100);
          
          if((finalTest + finalAssign + finalProj + finalQuiz) >= 50) {
            numPassed ++;
            System.out.println("Numpassed: " + numPassed);
          }
        }
        
        //write to output file
        FileWriter fileWriter = new FileWriter(outputFileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        
        bufferedWriter.newLine();
        bufferedWriter.write("Students passed: " + numPassed);
      }
    } catch(Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    
    
  }
}