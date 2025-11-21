package modul_7.praktikum1;

public class OverloadingTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        //test berbagai versi method add
        System.out.println("hasil: " + calc.add(5, 10));
        System.out.println();

        System.out.println("hasil: " + calc.add(5, 10, 15));
        System.out.println();

        System.out.println("hasil: " + calc.add(3.5, 2.7));
        System.out.println();

        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("hasil: " + calc.add(numbers));
        System.out.println();

        //demonstrasi automatic type promotion
        System.out.println("Automatic Type Promotion");
        System.out.println("hasil: " +calc.add(5, 3.5)); //int + double
    }
}
