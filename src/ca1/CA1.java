/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1;

//import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Lucas Fortunato
 */
public class CA1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        // Using a variable to hold the file path.
        File file = new File("Student.txt"); 

        // Using try and catch in case of has some issue to open the file.
        try{

            // Boolean var to hold TRUE if pass all te checks bellow.
            boolean check = true;

            // Read the file
            Scanner studentInfo = new Scanner(new FileReader(file)); 

            if(!studentInfo.hasNext()){
                System.out.println("Student file is Empty!");
                check = false;  
            }else{
                

                // Using variables to store each line of the file.
                String studentName = studentInfo.nextLine().trim(); 
                int numberOfClasses = studentInfo.nextInt(); 
                String studentNumber = studentInfo.nextLine().trim(); 

                // PRECISA CHECKAR SE AS VARIAVEIS ESTAO VAZIAS


                // Split the the full name in two parts.
                String[] names = studentName.split(" "); 
                
                // Take the second name.
                String secondName = names[1]; 
                
                // Assingn a null value for the workload, so we can populated it in the next check.
                String workload = null;

                // Check to determined what workload the student are assigned. 
                if(numberOfClasses < 1 || numberOfClasses > 8){
                    System.out.println("Number of classes is Invalid!:" + numberOfClasses);
                    check = false;
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
                if(numberOfClasses > 6){
                    workload = "Full Time";
                }
            
                // Check if the student number has a minimun of 6 characters.
                if(studentNumber.length() < 6){
                    System.out.println("Student number is Invalid!:" + studentNumber);
                    check = false;
                }

                // Check if first 2 characters of student number are numbers.
                String studentNumberFirstTwo = studentNumber.substring(0, 2);
                if (!studentNumberFirstTwo.matches("[0-9]+")) { 
                    System.out.println("The first 2 characters of student number has to be numbers: " + studentNumberFirstTwo);    
                    check = false;
                }

                // Check if the 3rd and 4th characters of student number are letters.
                String studentNumberThirdfourth = studentNumber.substring(2, 4);
                if (!studentNumberThirdfourth.matches("[a-zA-Z]+")) { 
                    System.out.println(" The 3rd and 4th characters of student number has to be letter: " + studentNumberThirdfourth);
                    check = false; 
                }

                // Check if the 5th character of student number is number or letter.
                String studentNumberFifth = studentNumber.substring(4, 5);
                if (!studentNumberFifth.matches("[a-zA-Z0-9]+")) { 
                    System.out.println(" The 5th character of student number has to be letter or number: " + studentNumberFifth);    
                    check = false;
                }

                // Check if the last characters of student number are numbers.
                String studentNumberLast = studentNumber.substring(5);
                if (!studentNumberLast.matches("[0-9]+")) { 
                    System.out.println("The last characters of student number has to be numbers: " + studentNumberLast); 
                    check = false;  
                }
                
                // If all the requeriments are ok, it will create a new text file called "status.txt", write the info as required, and save the file.
                if (check == true){
                    BufferedWriter output = new BufferedWriter(new FileWriter("status.txt"));
                    output.write(studentNumber + " - "+ secondName );
                    output.newLine();
                    output.write(workload);
                    output.newLine();
                    output.flush();
                    output.close();
                    System.out.println("File Saved");
                }else{
                    System.out.println("File not Saved");
                }
            
            }
          
        }catch(FileNotFoundException e){

        }    
    
    }   

}
