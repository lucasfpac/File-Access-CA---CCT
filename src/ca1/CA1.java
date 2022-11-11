/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1;

// IMPORTS
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Lucas Fortunato
 * Student_Number SBA21177
 * Github_Link https://github.com/lucasfpac/File-Access-CA---CCT
 * Portfolio https://lucasfortunato.com.br/
 * 
 */
public class CA1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        // Variable for the file path.
        File file = new File("student.txt"); 

        // Create the file status.txt and write the title.
        BufferedWriter output = new BufferedWriter(new FileWriter("status.txt"));
        output.write("------------------------------");
        output.newLine();
        output.write("****  CA1 Student Status  ****");
        output.newLine();
        output.write("**  Author: Lucas Fortunato **");
        output.newLine();
        output.write("** Student Number: SBA21177 **");
        output.newLine();

        // Variable holding the TRUE value, if the following test fail, it will be replaced by FALSE and shows an error!
        boolean check = true;

        // Variable to hold the number of students in the file.
        Integer numberOfStudents = 0;
    
        // Using try and catch in case of has some issue to open the file.
        try{

            // Read the file.
            Scanner studentInfo = new Scanner(new FileReader(file)); 

            // Statement to check if the file is Empty.
            if(!studentInfo.hasNext()){
                System.out.println("Student file is Empty!");
                check = false;  
            }else{
                
                // While loop to stop when it reach the end of the file.
                while (studentInfo.hasNextLine()) {

                    // Variables to store each line of the file.
                    String studentName = studentInfo.nextLine(); 
                    String Classes = studentInfo.nextLine(); 
                    String studentNumber = studentInfo.nextLine(); 

                    // Add 1 to the student number varible when it fills all the 3 varibles above.
                    ++numberOfStudents;
                    
                    /*------------------------------------ */
                    /* ----- CHECKS FOR STUDENT NAME ----- */
                    /*------------------------------------ */

                    // Check if the student name has letters, number and single space.
                    if (!studentName.matches("[a-zA-Z0-9\\s]*")) { 
                        System.out.println("Student number " + numberOfStudents + ": Something wrong with name/surname: " + studentName);
                        check = false;
                        break; 
                    }

                    // Split the the full name in two parts.
                    String[] names = studentName.split(" "); 
                    
                    // Take the second name from the Full name.
                    String firstName = names[0]; 
                    
                    // Check if the first name has just letters.
                    if (!firstName.matches("[a-zA-Z']+")) { 
                        System.out.println("Student number " + numberOfStudents + ": The first name is Invalid: " + firstName);
                        check = false;
                        break;
                    }

                    // Take the second name from the Full name.
                    String secondName = names[1]; 

                    // Check if the second name has letters and numbers.
                    if (!secondName.matches("[a-zA-Z0-9']+")) { 
                        System.out.println("Student number " + numberOfStudents + ": The second name is Invalid: " + secondName);
                        check = false;
                        break; 
                    }

                    /*------------------------------------------- */
                    /* ----- CHECKS FOR NUMBER OF CLASSES ------- */
                    /*------------------------------------------- */
                    
                    // convert the variable to INTEGER
                    int numberOfClasses = Integer.parseInt(Classes);

                    // Assingn a null value for the workload, so we can populated it in the next check.
                    String workload = null;

                    // Check to determined what workload the student are assigned. 
                    if(numberOfClasses < 1 || numberOfClasses > 8){
                        System.out.println("Student number " + numberOfStudents + ": Number of classes is Invalid!, it has to be between 1 and 8 : " + numberOfClasses);
                        check = false;
                        break;
                    }
                    if(numberOfClasses == 1){
                        workload = "Very Light";
                    }
                    if(numberOfClasses == 2){
                        workload = "Light";
                    }
                    if(numberOfClasses >= 3 && numberOfClasses <= 5 ){
                        workload = "Part Time";
                    }
                    if(numberOfClasses >= 6){
                        workload = "Full Time";

                    }
                    /*---------------------------------------- */
                    /* ----- CHECKS FOR STUDENT NUMBER ------- */
                    /*---------------------------------------- */

                    // Check if the student number has a minimun of 6 characters.
                    if(studentNumber.length() < 6){
                        System.out.println("Student number " + numberOfStudents + ": Student number is Invalid!, it has to be at least 6 digits: " + studentNumber);
                        check = false;
                        break;
                    }

                    // Check if first 2 characters of student number are numbers.
                    String studentNumberFirstTwo = studentNumber.substring(0, 2);
                    if (!studentNumberFirstTwo.matches("[0-9]+")) { 
                        System.out.println("Student number " + numberOfStudents + ": The first 2 characters of student number has to be numbers: " + studentNumberFirstTwo);    
                        check = false;
                        break;
                    }

                    // Check if the student number year is at least 2020.
                    int studentYear = Integer.parseInt(studentNumberFirstTwo);
                    if (studentYear < 20) { 
                        System.out.println("Student number " + numberOfStudents + ": The student year has to be at 2020: 20" + studentYear);    
                        check = false;
                        break;
                    }

                    // Check if the 3rd and 4th characters of student number are letters.
                    String studentNumberThirdfourth = studentNumber.substring(2, 4);
                    if (!studentNumberThirdfourth.matches("[a-zA-Z]+")) { 
                        System.out.println("Student number " + numberOfStudents + ": The 3rd and 4th characters of student number has to be letter: " + studentNumberThirdfourth);
                        check = false;
                        break; 
                    }

                    // Check if the 5th character of student number is number or letter.
                    String studentNumberFifth = studentNumber.substring(4, 5);
                    if (!studentNumberFifth.matches("[a-zA-Z0-9]+")) { 
                        System.out.println("Student number " + numberOfStudents + ": The 5th character of student number has to be letter or number: " + studentNumberFifth);    
                        check = false;
                        break;
                    }

                    // Check if the last characters of student number are numbers.
                    String studentNumberLast = studentNumber.substring(5);
                    if (!studentNumberLast.matches("[0-9]+")) { 
                        System.out.println("Student number " + numberOfStudents + ": The last characters of student number has to be numbers: " + studentNumberLast); 
                        check = false;
                        break;  
                    }

                    // Check if the number after the letter(s) is reasonable.
                    int lastNumbers = Integer.parseInt(studentNumberLast);
                    if (lastNumbers < 1 || lastNumbers > 200) { 
                        System.out.println("Student number " + numberOfStudents + ": The last characters of student number has to be 1 and 200: " + lastNumbers);    
                        check = false;
                        break;
                    }
                    /*--------------------------- */
                    /* ----- FILE WRITING ------- */
                    /*--------------------------- */
                    
                    // If all the the ckecks passes, it will write the infos as required, and save on the "status.txt" file.
                    if (check == true){
                        output.write("------------------------------");
                        output.newLine();
                        output.write("* Student: " + numberOfStudents);
                        output.newLine();
                        output.write("* "+ studentNumber + " - "+ secondName );
                        output.newLine();
                        output.write("* "+ workload);
                        output.newLine();
                        output.flush();
                        System.out.println("Student number " + numberOfStudents + ": Saved");
                    }
                }
                
            }
            output.write("------------------------------");
            output.newLine();
            output.write("**** End of the document ****");
            output.newLine();
            output.write("------------------------------");
            // CLose the file.
            output.close();
            
        // If the has something wrong with the reading file patch.  
        }catch(FileNotFoundException e){
            System.out.println("ERROR! File not found");
        }   
        
        }    
      }
  