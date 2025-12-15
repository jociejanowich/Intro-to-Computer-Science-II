import java.util.Scanner;
public class Lab9{
    //main method
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a positive integer for sum of digits: ");
        if (!scan.hasNextInt()) {
            System.out.println("Error: Input must be an integer!");
            return;
        }
        int sum = scan.nextInt();
        if (sum < 0) {
            System.out.println("Error: Input must be a positive integer!");
            return;
        }
        System.out.println("Iterative Sum: " + iterativeSum(sum));
        System.out.println("Recursive Sum: " + recursvieSum(sum));

        System.out.println("Enter an integer to convert to binary: ");
        if (!scan.hasNextInt()) {
            System.out.println("Error: Input must be an integer!");
            return;
        }
        int binaryNum = scan.nextInt();
        if (binaryNum < 0) {
            System.out.println("Error: Input must be a positive integer!");
            return;
        }
        System.out.println("Iterative binary number: " + iterativeBinary(binaryNum));
        System.out.println("Recursive binary number: " + recursiveBinary(binaryNum));

        System.out.println("Enter an integer you want to convert to a base: ");
        if (!scan.hasNextInt()) {
            System.out.println("Error: Input must be an integer!");
            return;
        }
        int convert = scan.nextInt();
        if (convert < 0) {
            System.out.println("Error: Input must be a positive integer!");
            return;
        }

        System.out.println("Enter a base integer: ");
        if (!scan.hasNextInt()) {
            System.out.println("Error: Input must be an integer!");
            return;
        }
        int base = scan.nextInt();
        if (base < 2) {
            System.out.println("Error: Base must be 2 or greater!");
            return;
        }

        System.out.println("Iterative: " + convert + " in base " + base + " is " + iterativeBase(convert, base));
        System.out.println("Recursive: " + convert + " in base " + base + " is " + recursiveBase(convert, base));


    }

    //ITERATIVE METHODS
    public static int iterativeSum(int num){
        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
        
    }

    public static String iterativeBinary(int num){
        if (num == 0) return "0";
        String binary = "";
        while (num > 0){
            int remainder = num % 2;
            binary = remainder + binary;
            num /= 2;
        }
        return binary;
    }

    public static String iterativeBase(int num, int base){
        String output = " ";
        int remainder;
        String digits = "01223456789ABCDEF";
        while (num > 0){
            remainder = num % base;
            char digit = digits.charAt(remainder);
            output = digit + output;
            num = num / base;
        }
        return output;
    }


    //RECURSIVE METHODS
    public static String recursiveBinary(int num){
        if (num == 0) return "0";
        return recursiveBinary(num / 2) + (num % 2);
    }

    public static int recursvieSum(int num){
        if (num == 0) return 0;
        return (num % 10) + recursvieSum(num / 10);
    }

    public static String recursiveBase(int num, int base){
        String digits = "0123456789ABCDEF";
        if (num < base) return String.valueOf(digits.charAt(num));
        return recursiveBase(num / base, base) + digits.charAt(num % base);
    }
}