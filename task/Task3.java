

class Task3 {

    public static void main(String[] args) {
        String a = "Wow";
        String b = a;
        String c = "Different";
        String d = c + "!";

        boolean b1 = a == b;
        boolean b2 = d.equals(d + "!");
        boolean b3 = !c.equals(a);

        if(b1 && b2 && b3);
            System.out.println("succcess");


    }
}