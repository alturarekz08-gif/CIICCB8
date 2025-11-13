package chapter4;

public class ReturnType {
    void StartEngine(){
        System.out.println("Engine is starting");
    }
    int getAge(){
        return 23;
    }
    Avocado getAvocado(){
        return null;
    }
    public static void main(String[] args) {
        ReturnType rt= new ReturnType();
        System.out.println("Good Morning you are "+" 23 years old ");
        int y = 123456, z= 2;

    }

} 


class Avocado{
    
}