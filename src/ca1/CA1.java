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
 * @author lucasfortunato
 */
public class CA1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("Student.txt"); // Using a variable to hold the file path, so if we need to use it more the once it will be easier
        try{ // using try and catch in case of has some issue to open the file
            Scanner myReader = new Scanner(new FileReader(file)); // read the file
            
            String studentName = myReader.nextLine(); // Read first line of the file
            int numberOfClasses = myReader.nextInt(); 
            String studentNumber = myReader.next();
            
            String[] names = studentName.split(" "); // split the names
            //String firstName = names[0]; // first name
            String secoundName = names[1]; // secound name
            
            String workload = null;
            
            if(numberOfClasses < 1 || numberOfClasses > 8){
                System.out.println("Number of classes is Invalid :(");
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
            
            
             
            
            if(studentNumber.length() < 6){
                System.out.println("Student number is Invalid! :(");
            }
            
                
            System.out.println(" ");
            System.out.println(studentNumber.substring(0, 2));

            //input
            System.out.println("INPUT:");
            System.out.println(studentName);
            System.out.println(numberOfClasses);
            System.out.println(studentNumber);
            
            System.out.println(" ");
            System.out.println(" ");
            
            //output
            System.out.println("OUTPUT:");
            System.out.println(studentNumber + "-"+ secoundName );
            System.out.println(workload);
            
            
            
        }catch (FileNotFoundException e ){
            
        }
        
        
        /*try{
            File file = new File("Student.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while((st=br.readLine()) != null){
                System.out.println(st);
            }
        }catch (Exception e){
            System.out.println("File access error!");
        }*/
    }
    
}
