import java.util.*;
public class lab1Part1{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int guess;
        int count = 1;
        int number = (int)(Math.random()*90) + 10;
        System.out.println(number);
        System.out.println("Try to guess the 2 digit secret number in between 10 and 100.");
        
        while (!scan.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer:");
            count++;

            scan.next();
        }
        guess = scan.nextInt();
        
        while (guess != number && count <= 10){
            if((guess % 10 == number % 10) || (guess % 10 == number / 10)){
                System.out.println("You got one digit correct");
            }
            else if ((guess / 10 == number % 10) || (guess / 10 == number / 10)){
                System.out.println("You got one digit correct");
            }
            else{
                System.out.println("You got no digits correct");
            }
            System.out.println("Try again");
            count++;
            
            while (!scan.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer:");
                scan.next();
            }
            guess = scan.nextInt();
        }
        if (count <= 10){
            System.out.println("You got it in " + count + " tries.");
        }
        else{
            System.out.println("You didn't get it in 10 tries. The number was " + number);
        }
    }
}