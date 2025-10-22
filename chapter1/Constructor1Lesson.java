package chapter1;

public class Constructor1Lesson {
    public static void main(String[] args) {
        Duck d1 = new Duck();
        Duck d2 = new Duck();
        System.out.println();

    }
    
}
class Duck{
    int numEggs = 0;
    String name;
    public Duck(){
        name = "Peter";
    }
}
class Eagle{
    int numberEggs;
    public static void main(String[] args) {
        Eagle mother = new Eagle();
        mother.numberEggs = 2;
        System.out.println("Eagle number off eggs:" + mother.numberEggs);

    }
}
class Name{
    String first = "Rex";
    String second = "Kamote";
    String full = (first + second);
    public static void main(String[] args) {
        Name name1 = new Name();
        System.out.println(name1.full);
        name1.first = "Joaquin";
        name1.second = "Burdado";

    }
}