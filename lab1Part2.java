import java.util.*;
public class lab1Part2{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to start? (Y/N)");
        String input = scan.nextLine();
        int num;
        if(input.equals("Y")){
            while (true) {
                System.out.println("How many chars per row?");
                if (scan.hasNextInt()) {
                    num = scan.nextInt();
                    if (num >= 5 && num <= 21) {
                        break; 
                    } else {
                        System.out.println("Must be between 5 and 21, try again.");
                        scan.next();
                    }
                    break; 
                } else {
                    System.out.println("Must be an integer, try again.");
                    scan.next(); 
                }
            }
            System.out.println("What character?");
            input = scan.next();
            for(int i = 0; i < num; i++){
                System.out.print(input);
            }
            System.out.println();
            for (int row = 0; row < num - 2; row++) {
                System.out.print(input);
                for (int col = 0; col < num - 2; col++) {
                    System.out.print(" ");
                }
                System.out.println(input); 
            }
         
            for(int i = 0; i < num; i++){
                System.out.print(input);
            }
                
        }
        
        
            
        }
    }
