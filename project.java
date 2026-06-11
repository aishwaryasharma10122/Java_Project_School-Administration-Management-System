import java.util.Scanner;

// Interface
interface Printable {
    void printDetails();
}

// Custom Exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Abstract Base Class
abstract class Person implements Printable {

    private String name;
    private int age;

    public Person(String name, int age) throws InvalidAgeException {

        if (age <= 0) {
            throw new InvalidAgeException("Age must be greater than 0");
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void displayBasicInfo() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }

    public abstract void showRole();
}

// Teacher Class
class Teacher extends Person {

    private String subject;
    private double salary;

    public Teacher(String name, int age,
                   String subject, double salary)
            throws InvalidAgeException {

        super(name, age);
        this.subject = subject;
        this.salary = salary;
    }

    @Override
    public void showRole() {
        System.out.println("I am a Teacher. I teach students.");
    }

    @Override
    public void printDetails() {
        displayBasicInfo();
        System.out.println("Subject : " + subject);
        System.out.println("Salary  : " + salary);
    }

    // Method Overloading
    public void calculateSalary() {
        System.out.println("Monthly Salary : " + salary);
    }

    public void calculateSalary(int bonus) {
        System.out.println("Salary with Bonus : " + (salary + bonus));
    }
}

// Student Class
class Student extends Person {

    private int rollNumber;
    private String course;

    public Student(String name, int age,
                   int rollNumber, String course)
            throws InvalidAgeException {

        super(name, age);
        this.rollNumber = rollNumber;
        this.course = course;
    }

    @Override
    public void showRole() {
        System.out.println("I am a Student. I study subjects.");
    }

    @Override
    public void printDetails() {
        displayBasicInfo();
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Course      : " + course);
    }
}

// Main Class
public class SchoolManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // Runtime Polymorphism using Person Array
            Person[] people = new Person[2];

            people[0] = new Teacher(
                    "Rahul Sharma",
                    35,
                    "Java Programming",
                    45000
            );

            people[1] = new Student(
                    "Aman Verma",
                    20,
                    101,
                    "B.Tech AI & ML"
            );

            System.out.println("=================================");
            System.out.println(" SCHOOL ADMINISTRATION SYSTEM ");
            System.out.println("=================================");

            for (Person p : people) {

                System.out.println("\n-------------------------");

                p.showRole();       // Runtime Polymorphism
                p.printDetails();   // Method Overriding
            }

            // String Handling
            System.out.println("\n===== STRING HANDLING =====");

            String schoolName = "ABC School";

            StringBuilder sb = new StringBuilder(schoolName);
            sb.append(" Management System");

            System.out.println("StringBuilder : " + sb);

            StringBuffer sf = new StringBuffer("Secure Data");
            sf.append(" Processing");

            System.out.println("StringBuffer  : " + sf);

            // Method Overloading
            System.out.println("\n===== SALARY DETAILS =====");

            Teacher t = (Teacher) people[0];

            t.calculateSalary();
            t.calculateSalary(5000);

            // Switch Statement
            System.out.println("\n===== MENU =====");
            System.out.println("1. Teacher Module");
            System.out.println("2. Student Module");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Teacher Module Selected");
                    break;

                case 2:
                    System.out.println("Student Module Selected");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }

        catch (InvalidAgeException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        }

        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        finally {
            System.out.println("\nProgram Executed Successfully.");
        }

        sc.close();
    }
}
