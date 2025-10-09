import java.io.*;
import java.util.*;
public class lab2Part3{
    public static void main(String[] args) throws IOException {
         File file = new File("students.txt");

        Scanner scan = new Scanner(file);
        int rows = 0;
        while (scan.hasNextLine()) {
            String line = scan.nextLine().trim();
            if (!line.isEmpty() && line.contains(",")) {
                rows++;
            }
        }
        scan.close();

        String[][] students = new String[rows][];
        Scanner fileScan = new Scanner(file);
        int index = 0;
        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine().trim();
            if (!line.isEmpty() && line.contains(",")) {
                students[index] = line.split(",");
                index++;
            }
        }
        fileScan.close();

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\nSelect a student to view (or 0 to exit):");
            for (int i = 0; i < students.length; i++) {
                String firstName = students[i].length > 0 ? students[i][0] : "Unknown";
                String lastName = students[i].length > 1 ? students[i][1] : "";
                System.out.println((i + 1) + ". " + firstName + " " + lastName);
            }

            System.out.print("Choice: ");
            if (!input.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                input.next(); 
                continue;
            }

            int choice = input.nextInt();
            if (choice == 0) break;
            if (choice < 1 || choice > students.length) {
                System.out.println("Invalid choice, try again.");
                continue;
            }

            // Print full record
            System.out.println("Full Record: " + String.join(", ", students[choice - 1]));
        }

        input.close();
    }

}
   
