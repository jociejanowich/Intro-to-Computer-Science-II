import java.io.*;
import java.util.*;
public class lab2Part1{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner scan = new Scanner(new File("input.txt"));
        double sum = 0;
        double average;
        int count = 0;
        double max = 0;
        while (scan.hasNext()){
            if (scan.hasNextDouble()){
                double num = scan.nextDouble();
                sum += num;
                if (num > max){
                    max = num;
                }
                count++;
            }
            else{
                scan.next();
            }
        }
        average = sum/count;
        System.out.println("Average: " + average);
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);



    }
}