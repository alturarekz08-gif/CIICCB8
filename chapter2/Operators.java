package chapter2;
public class Operators {
    public static void main(String[] args) {
        //shift ops
        System.out.println(2<<2);
        System.out.println(15>>1);

        System.out.println(+3 + +6);
        int a = 0;
        System.out.println(a++);
        System.out.println(a);//1
        System.out.println(++a);//2
        System.out.println(a);
        short x = 10;
        short y = 30;
        short z =(short) (x*y);
        System.out.println("z="+z);
        System.out.println(a++ - ++a); //2 - 4
        System.out.println(a);
    }
    
}