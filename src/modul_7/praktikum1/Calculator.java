package modul_7.praktikum1;

public class Calculator {

    //method untuk menjumlahkan dua integer
    public int add(int a, int b) {
        System.out.println("memanggil add(int, int)");
        return a + b;
    }

    //overload method untuk menjumlahkan tigs integer
    public int add(int a, int b, int c) {
        System.out.println("memanggil add (int, int, int)");
        return a + b + c;
    }

    //overload method untuk menjumlahkan dua double
    public double add(double a, double b) {
        System.out.println("memanggil add(double, double)");
        return a + b;
    }

    //overload method untuk menjalankan array integer
    public int add(int[] numbers) {
        System.out.println("memanggil add (int[])");
        int sum = 0;
        for (int num: numbers) {
            sum += num;
        }
        return sum;
    }

    //overload method untuk concatenate strings
    public  String add( String a, String b) {
        System.out.println("memanggil add(String, String)");
        return a + b;
    }
}
