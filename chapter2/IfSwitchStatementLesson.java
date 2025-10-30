package chapter2;

public class IfSwitchStatementLesson {
    public static void main(String[] args) {
        int hourofDay=22;
        if(hourofDay<11);
            System.out.println("Good Morning");
        System.out.println("Good Afternoon");

        if(hourofDay<11)
            System.out.println("good morning");
        else
            System.out.println("Good Afternoon");
        System.out.println("Good Afternoon");

        if(hourofDay>=10)
            System.out.println("good evening");
        else if(hourofDay>=10)
            System.out.println("Good Afternoon");
        else
            System.out.println("Good Morning");

        System.out.println((hourofDay>=18)?"Good Eve":(hourofDay>=12)?"Good Afternoon":"Good Morning");

        int monthOfYear = 13;
        switch (monthOfYear){
            case 1: System.out.println("january");
                    break;
            case 2: System.out.println("february");
                    break;
            case 3: System.out.println("march");
                    break;
            case 4: System.out.println("april");
                    break;
            case 5: System.out.println("may");
            
            case 6: System.out.println("june");
                    break;
            default:
                    System.out.println("not include in the year");
                    break;
            case 7: System.out.println("july");
                    break;
            case 8: System.out.println("august");
                    break;
            case 9: System.out.println("september");
                    break;
            case 10: System.out.println("october");
                    break;
            case 11: System.out.println("november");
                    break;
            case 12: System.out.println("december");
                    break;

            
            
            
        }


    }
    
}