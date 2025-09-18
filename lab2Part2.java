import java.io.*;
import java.util.*;
public class lab2Part2{
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new FileWriter("students.txt", true));
        while (true) { 
            System.out.println("First name: ");
            String firstName = scan.nextLine();
            System.out.println("Last Name: ");
            String lastName = scan.nextLine();
            System.out.println("Letter grade: ");
            String grade = scan.nextLine();
            System.out.println("Year Taken: ");
            int year = scan.nextInt();
            scan.nextLine();

            out.println(firstName + " " + lastName + " " + grade + " " + year);
            System.out.println("Would you like to input more students? y/n");
            if(scan.nextLine().equalsIgnoreCase("n")){
                break;
            }
        }
        out.close();
        System.out.println("Completed");
    }
}