/** 
 * Toy Object
 *  has property of name, brand, price, quantity
 * with a method of setPrice() where you can change
 * the price of a toy object
 * 
 * 
*/
public class Toy {
    String name;
    String brand;
    double price;
    int quantity;
    // void is a return statement
    void setPrice(double price){
        this.price = price;

    }
    public static void main(String[] args) {
        Toy toy1 = new Toy(); //state
        toy1.name = "Rage Kamote"; //state
        toy1.brand = "Bangkai"; //state
        toy1.price = 4500; //state
        toy1.quantity = 12; //state
        toy1.setPrice((toy1.price*0.5));
        System.out.println(toy1.price);
    }
}
class Fruit1 {

}
class Fruit2 {

}
class Fruit3 {

}
class Fruit4 {
    public static void main(String[] args) {
        System.out.println("I am fruit 5");
    }
}