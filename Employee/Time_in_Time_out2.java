

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time_in_Time_out2 {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Employee> employees = new ArrayList<>();
    // Added a formatter for a cleaner look in 2026
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void main(String[] args) { // Added String[] args
        boolean running = true;

        while (running) {
            System.out.println("\n====== Employee Biometrics ======");
            System.out.println("1. Register & Time-in");
            System.out.println("2. View All Records");
            System.out.println("3. Time-out");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            // Input validation for menu
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewAttendance();
                    break;
                case 3:
                    recordTimeout();
                    break;
                case 4:
                    running = false;
                    System.out.println("Program Exited.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void addEmployee() {
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // FIX: You must actually create the object and add it to the list
        Employee newEmp = new Employee(name, id);
        employees.add(newEmp);

        System.out.println("Employee " + name + " added and Time-in recorded at " + newEmp.timein.format(dtf));
    }

    static void viewAttendance() {
        System.out.println("\n--- Attendance List ---");
        if (employees.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Employee e : employees) {
                System.out.println(e);
            }
        }
    }

    static void recordTimeout() {
        System.out.print("Enter Employee ID to time-out: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (Employee e : employees) {
            if (e.getEmployeeid() == id) {
                e.setTimeout();
                System.out.println("Time-out recorded for " + e.name + " at " + e.timeout.format(dtf));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Error: Employee ID not found.");
        }
    }

    // FIX: Added 'static' so the main method can access it
    static class Employee {
        private String name;
        private int employeeid;
        private LocalTime timein;
        private LocalTime timeout;

        public Employee(String name, int employeeid) {
            this.name = name;
            this.employeeid = employeeid;
            this.timein = LocalTime.now();
        }

        public int getEmployeeid() {
            return employeeid;
        }

        public void setTimeout() {
            this.timeout = LocalTime.now();
        }

        @Override
        public String toString() {
            return String.format("ID: %-5d | Name: %-10s | In: %-10s | Out: %-10s",
                    employeeid,
                    name,
                    timein.format(dtf),
                    (timeout == null ? "STILL IN" : timeout.format(dtf)));
        }
    }
}