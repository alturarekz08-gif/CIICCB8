public class CarBrand {
    String name;
    int year;

    public CarBrand() {
        name = "unknown";
        year = 0;
    }

    public CarBrand(String b, int y) {
        name = b;
        year = y;

    }
    

    void displayInfo() {
        System.out.println("car:" + name +" | Year: " + year);

    }
    public static void main(String[] args) {
        CarBrand c1 = new CarBrand();
        CarBrand c2 = new CarBrand("Honda", 2024);
        c1.displayInfo();
        c2.displayInfo();

        
    }
}