package modul_7.praktikum2;

public class Shape {
    protected String color;

    public  Shape(String color) {
        this. color = color;
    }

    public void draw() {
        System.out.println("menggambar shape dengan warna: " + color);
    }

    public double calculateArea() {
        System.out.println("menghitung luas shape umum");
        return 0.0;
    }

    public void displayInfo() {
        System.out.println("shape - warna: " +color);
    }
 }
