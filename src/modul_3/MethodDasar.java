package modul_3;

public class MethodDasar {

    public static void tampilkanHeader() {
        System.out.println("=========================");
        System.out.println("   PROGRAM KALKULATOR SEDERHANA");
        System.out.println("=========================");
        System.out.println();
    }
    public static void tampilkanHasil(String operasi, double a, double b, double hasil) {
        System.out.printf("%.2f %s %.2f = %.2f%n", a, operasi, b, hasil);
    }
    public static double tambah(double a, double b) {
        return a + b;
    }
    public static double kurang(double a, double b) {
        return a - b;
    }
    public static double kali(double a, double b) {
        return a * b;
    }
    public static double bagi(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Pembagian dengan nol!");
            return Double.NaN; // NaN = Not a Number
        } else {
            return a / b;
        }
    }

    public static boolean validasiAngka(double angka) {
        return !(Double.isNaN(angka) || Double.isInfinite(angka));
    }

    public static void main(String[] args) {
        tampilkanHeader();

        double x = 15.5;
        double y = 4.2;

        if (validasiAngka(x) && validasiAngka(y)) {
            double hasilTambah = tambah(x, y);
            double hasilKurang = kurang(x, y);
            double hasilKali = kali(x, y);
            double hasilBagi = bagi(x, y);

            tampilkanHasil("+", x, y, hasilTambah);
            tampilkanHasil("-", x, y, hasilKurang);
            tampilkanHasil("*", x, y, hasilKali);
            tampilkanHasil("/", x, y, hasilBagi);
        }
    }
}