import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    running = false;
                    System.out.println("Program exited.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // METHOD: Add Student
    static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        Student student = new Student(name, age);
        students.add(student);

        System.out.println("Student added successfully!");
    }

    // METHOD: View Students
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}

// STUDENT CLASS
class Student {

    private String name;
    private int age;

    // CONSTRUCTOR
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // toString METHOD
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}
