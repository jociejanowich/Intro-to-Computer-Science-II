import java.util.*;
public class Person{
    private String firstName;
    private String lastName;
    //defualt constructor
    public Person(){
        firstName = "";
        lastName = "";
    }
    //alternate constructor
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //first name getter
    public String getFirstName(){
        return firstName;
    }
    //last name getter
    public String getLastName(){
        return lastName;
    }
    //sets name
    public void setName(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //method prints first name
    public void printFirstName(){
        System.out.println(firstName);
    }
    //method prints first and last name
    public void printFullName(){
        System.out.println(firstName + " " + lastName);
    }
    //toString
    public String toString(){
        return firstName + " " + lastName;
    }
    //copy method 
    public void copy(Person otherPerson){
        this.firstName = otherPerson.firstName;
        this.lastName = otherPerson.lastName;
    }
    //equals method
    public boolean equals(Person otherPerson){
        if (this == otherPerson){
            return true;
        }
        Person other = (Person) otherPerson;
        return this.firstName.equals(otherPerson.firstName) && this.lastName.equals(other.lastName);
    }
    //get copy method
    public Person getCopy(){
        return new Person(this.firstName, this.lastName);
    }

    //main method
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Employee e1 = new Employee("Jocelyn", "Janowich", 16.50, 20, "CIS");
        System.out.println("Enter employee last name: ");
        String last = scan.nextLine();
        System.out.println("Enter employee first name: ");
        String first = scan.nextLine();
        System.out.println("Enter department: ");
        String department = scan.nextLine();
        System.out.println("Enter pay rate: ");
        double payRate = scan.nextDouble();
        System.out.println("Enter hours worked: ");
        double hours = scan.nextDouble();
        Employee e2 = new Employee (first, last, payRate, hours, department);
        System.out.println(" --- Record for both employees overridden .toString from subclass ---");
        System.out.println(e1);
        System.out.println(e2);
        System.out.println("--- Output with calls to overridden method print from subclass ---");
        e1.print();
        e2.print();
        System.out.println("--- Output with calls to getters from the supercalss ---");
        System.out.println(e2.toString());
        System.out.println("--- Call to overrideen equals/subclass for 2 Employee objects---");
        if (e1.equals(e2)){
            System.out.println("Found employee with same record");
        } else{
            System.out.println("Couldn't find an employee with same record");
        }
    }
}

class Employee extends Person{
    private double payRate;
    private double hoursWorked;
    private String department;

    public final int HOURS = 40;
    public final double OVERTIME = 1.5;
    
    //alternate
    public Employee(String first, String last, double rate, double hours, String dep){
        super(first, last);
        payRate = rate;
        hoursWorked = hours;
        department = dep;
    }
    //default
    public Employee(){
        super();
        payRate = 0;
        hoursWorked = 0;
        department = "";
    }
    //print method
    public void print(){
        System.out.println("The employee " + getFirstName() + " " + getLastName() + " from the " + department + " worked " + hoursWorked + " with a payrate of $" + payRate + ". The wages for this employee are $" + calculatePay());
    }

    public double calculatePay(){
        if (hoursWorked <= HOURS){
            return payRate * hoursWorked;
        } else{
            double overtimeHours = hoursWorked - HOURS;
            return (HOURS * payRate) + (overtimeHours * payRate * OVERTIME);
        }
    }
    public void setAll(String first, String last, double rate, double hours, String dep){
        setName(first, last);
        payRate = rate;
        hoursWorked = hours;
        department = dep;
    }
    public double getPayRate(){
        return payRate;
    }
    public double getHoursWorked(){
        return hoursWorked;
    }
    public String getDepartment(){
        return department;
    }
    public boolean equals(Object otherEmployee){
        if (this.equals(otherEmployee)){
            return true;
        }
        Employee e = (Employee) otherEmployee;
        return super.equals(e) && payRate == e.payRate && hoursWorked == e.hoursWorked && department.equals(e.department);

    }

    public void copy(Employee e){
        super.copy(e);
        this.payRate = e.payRate;
        this.hoursWorked = e.hoursWorked;
        this.department = e.department;
    }

    public Employee getCopy(){
        return new Employee(getFirstName(), getLastName(), payRate, hoursWorked, department);
    }

    public String toString(){
        return "The wages for " + getFirstName() + " " + getLastName() + " from the " + department + "are $" + calculatePay();
    }
}

