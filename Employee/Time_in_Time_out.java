

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;


public class Time_in_Time_out {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Employee> employees = new ArrayList<>();
    // Added a formatter for a cleaner look in 2026
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    static void main() {
        boolean running = true;


        while (running) {
            System.out.println("\n======Employee Biometrics======");
            System.out.println("1. Add Employee (Time-in) "); //name
            System.out.println("2. Add Employeeid "); //employeedid
            System.out.println("3. time-in"); //timein
            System.out.println("4. time-out "); //timeout
            System.out.println("5. exit ");
            System.out.println("choose option's? ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                   addemployeename();
                   break;
//                case 2:
//                    addemployeeid();
//                    break;
                case 3:
                    viewtimein();
                    break;
                case 4:
                    viewtimeout();
                    break;
                case 5:
                    running=false;
                    System.out.println("Program Exited ");
                    break;
                    


            }
        }
    }
    static void addemployeename() {

        System.out.println("Enter EmployeeName");
        String name = scanner.nextLine();


        System.out.println("Add EmployeeID");
        int employeeid = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Employee added. Time-in recorded!");
    }

    static void viewtimein() {
        System.out.println("\n-- Employee Time-in List --- ");
        if (employees.isEmpty()) {
            System.out.println("No  Employees yet.!");
        }
        for (Employee e : employees) {
            System.out.println(e);
        }

    }
    static void viewtimeout() {
        System.out.print("Enter Employee ID to time-out: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Employee e : employees) {
            if (e.getEmployeeid() == id) {
                e.setTimeout();
                System.out.println("Time-out recorded!");
                return;
            }
        }

        System.out.println("Employee not found.");
    }





    class Employee {
        private String name;
        private int employeeid;
        private LocalTime timein;
        private LocalTime timeout;

        public Employee(String name, int employeeid) {
            this.name = name;
            this.employeeid = employeeid;
            this.timein = LocalTime.now();
        }

        public int getEmployeeid(){
            return employeeid;
        }

        public void setTimeout() {
            this.timeout = LocalTime.now();
        }

        @Override
        public String toString() {
            return "Name: " + name +
                    " | ID: " + employeeid +
                    " | Time-In: " + timein +
                    " | Time-Out: " + (timeout == null ? "N/A" : timeout);
        }
    }

}
