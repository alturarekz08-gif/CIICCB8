public class Student {
    String name;
    int age;
    String zone;

    public Student(String n, int a, String z) {
        name = n;
        age = a;
        zone = z;

    }
    void display() {
        System.out.println(name + " is " + age + " years old " + " North Manila ");
    }
    public static void main(String[] args) {
        Student s1 = new Student("Rex", 27, "North Manila");
        s1.display();
        Student s2  = new Student("Joaquin", 8, " North Manila ");
        s2.display();
    }
}
