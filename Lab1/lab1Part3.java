import java.util.*;
public class lab1Part3{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int height = 0;
            while (true) {
                System.out.print("Enter diamond height (odd integer 5–21): ");
                if (!scan.hasNextInt()) {
                    System.out.println("Not an integer! Try again.");
                    scan.next(); 
                    continue;
                }
                height = scan.nextInt();
                if (height < 5 || height > 21 || height % 2 == 0) {
                    System.out.println("Must be an odd number between 5 and 21.");
                } else {
                    break; 
                }
            }
            int mid = height / 2;
            for (int i = 0; i < height; i++) {
                int row = (i <= mid) ? (2 * i + 1) : (2 * (height - i - 1) + 1);
                for (int s = 0; s < (height - row) / 2; s++) {
                    System.out.print("  "); 
                }
                int numbers = row;
                for (int n = 1; n <= numbers; n++) {
                    System.out.print(n + " ");
                }
                System.out.println();
            }
            System.out.print("Do you want to continue (Y/N): ");
            scan.nextLine(); 
            String choice = scan.nextLine().trim().toUpperCase();
            if (!choice.equals("Y")) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
        
