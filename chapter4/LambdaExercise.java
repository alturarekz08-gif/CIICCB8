package chapter4;
import java.util.*;
import java.util.function.Predicate;;




public class LambdaExercise {
    static void print(List<Vehicle> cars,Predicate<Vehicle> checker){
        for(Vehicle car:cars){
            if(checker.test(car)){
                System.out.println(car+", ");
            }
        }
        System.out.println("....................");
    }
    public static void main(String[] args) {
        double[] v1 = {1, 2, 3};
        double[] v2 = {4, 5, 6};
        
        double[][] m1 = {
            {1, 2},
            {3, 4}
    };

        double[][] m2 = {
            {5, 6},
            {7, 8}
    };
    functionX f = (x) -> x * x;
    functionX derivative = (x) -> {
        double h =2e-10;
        return (f.apply(x + h) - f.apply(x - h)) / (2 * h);
    };
    functionX g = x -> x * x;
    IntegralOp integral = (func, a, b) -> {
        int n = 10_000;
        double dx = (b - a) / n;
        double sum = 0;

        for(int i = 0; i < n; i++) {
            double x = a + i * dx;
            sum += func.apply(x) * dx;
        }
        return sum;
        };
    

        List<Vehicle> cars = new ArrayList<Vehicle>();
        cars.add(new Vehicle("Nissan", false, true, 10));
        cars.add(new Vehicle("Ferrari", true, false, 15));
        cars.add(new Vehicle("RollsRoyce", false, true, 23));
        cars.add(new Vehicle("Kia", true, false, 10));
        cars.add(new Vehicle("Bugatti", true, true, 30));
        cars.add(new Vehicle("Lamborgini", false, true, 60));
                print(cars, a->a.canRace());
                print(cars, a->a.canElegant());
                print(cars, a->(a.canRace() && a.canElegant()));
                print(cars, a->(!a.canRace() && !a.canElegant()));
                print(cars, Vehicle::canRace);
                print(cars, a->a.getAge()>20);
                print(cars, a->a.getAge()<=15);
                NumberInterface sum = (a,b)->a+b;
                NumberInterface dif = (a,b)->a-b;
                NumberInterface prod = (a,b)->a*b;
                NumberInterface qou = (a,b)->a/b;
                System.out.println(sum.aOperateB(4, 4));
                System.out.println(dif.aOperateB(4, 4));
                System.out.println(prod.aOperateB(4, 4));
                System.out.println(qou.aOperateB(4, 4));
                DiscountItem tenper = (x)->(x-(x*0.10));
                DiscountItem twentyper = (x)->(x-(x*0.20));
                DiscountItem fiftyper = (x)->(x-(x*0.50));
                int backKick = 10_000_000;
                System.out.println(tenper.dc(backKick));
                System.out.println(twentyper.dc(backKick));
                System.out.println(fiftyper.dc(backKick));
                System.out.println(cars);
                cars.removeIf(a->a.canRace());
                System.out.println(cars);
                PolygonArea square = (s) -> (s[0] * s[0]);
                PolygonArea rectangle = (s) -> s[0] * s[1];
                VectorOp vAdd = (a,b) -> new double[]{
                a[0] + b[0],
                a[1] + b[1],
                a[2] + b[2]
                };
                VectorOp dot = (a,b) -> new double[]{
                    a[0]*b[0] + a[1]*b[1] + a[2]*b[2]
                };
                VolumeOp cube = (d) -> d[0] * d[0] * d[0];
                
                MatrixOP madd = (A,B) -> new double[][]{
                    {A[0][0] + B[0][0], A[0][1] + B[0][1]},
                    {A[1][0] + B[1][0], A[1][1] + B[1][1]}
                };
                MatrixOP mMul = (A,B) -> new double[][]{
                    {
                        A[0][0]*B[0][0] + A[0][1]*B[1][0],
                        A[0][0]*B[0][1] + A[0][1]*B[1][1]     
                    },
                    {
                        A[1][0]*B[0][0] + A[1][1]*B[1][0],
                        A[1][0]*B[0][1] + A[1][1]*B[1][1]
                    }
                };
                MatrixOP mSub = (A,B) -> new double[][]{
                    {A[0][0] - B[0][0], A[0][1] - B[0][1]},
                    {A[1][0] - B[1][0], A[1][1] - B[1][1]}
                };
                
                
                
        
        
                System.out.println("Square Area: " + square.area(10));
                System.out.println("Rectangle area: " + rectangle.area(10, 5));
                System.out.println("Vector Add: " + Arrays.toString(vAdd.apply(v1,v2)));
                System.out.println("Dot Product: " + Arrays.toString(dot.apply(v1,v2)));
                // Sphere (4/3 π r³)
                System.out.println("Cube Vol: " + cube.compute(3.1416));
                System.out.println("Matrix Add: " + Arrays.deepToString(madd.apply(m1,m2)));
                System.out.println("Matrix Mul: " + Arrays.deepToString(mMul.apply(m1,m2)));
                System.out.println("Matrix Sub: " + Arrays.deepToString(mSub.apply(m1,m2)));
                System.out.println("f'(5) ≈ " + derivative.apply(5));
                System.out.println("∫ x^2 dx from 0 to 3 ≈ " + integral.compute(f, 0, 3));




    }

    
}
class Vehicle{
    private String model;
    private boolean canRace;
    private boolean canElegant;
    private int age;
    public Vehicle(String modelName,boolean racer,boolean richer,int age){
        model = modelName;
        canRace = racer;
        canElegant = richer;
        this.age = age;
    }
    public boolean canRace(){ return canRace;}
    public boolean canElegant(){ return canElegant;}
    public int getAge(){ return age;}
    public String toString(){ return model;}
}
interface NumberInterface{
    int aOperateB(int a, int b);
}
interface DiscountItem{
    double dc(double c);
}
interface PolygonArea {
    double area(double... sides);
}
interface VectorOp {
    double[] apply(double[] a, double[] b);
}
interface VolumeOp {
    double compute(double... dims);
}
interface MatrixOP {
    double[][] apply(double[][] a, double[][] b);
}
interface functionX {
    double apply(double x);
}
interface IntegralOp {
    double compute(functionX f, double a, double b);
}