package chapter4;

public class AccessModifieer {
    private void greetMe(){
        System.out.println("hello java world");
    }
    private void greetMe2(){
        System.out.println("hello java people");
    }
    protected void greetMe3(){
        System.out.println("hello java protected people");
    }
    void greetMe4(){
        System.out.println("hello java default people");
    }
    
    public static void main(String[] args) {
        AccessModifieer acm1 = new AccessModifieer();
        acm1.greetMe();
        acm1.greetMe2();
        acm1.greetMe3();
         acm1.greetMe4();
    }
}
