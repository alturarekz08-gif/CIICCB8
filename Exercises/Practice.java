

public class Practice {

    public static void main(String[] args) {
        
    
        ArrayList<Integer> values = new ArrayList<>();
        values.add(4);
        values.add(5);
        values.set(1, 6);
        values.remove(0);
        for (Integer v : values) System.out.print(v);
    }
} 