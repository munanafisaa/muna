package praktikum1;

public class Person {
    //private - hanya bisa diakses dalam class ini
    private String nama;
    private int umur;

    //default (package private)- bisa diakses dalam package yang sama
    String alamat;

    //protected bisa diakses dalam package subclass
    protected String telepon;

    //public bisa diakses dari mana saja
    public String email;

    //constructor
    public Person(String nama, int umur){
        this.nama = nama;
        this.umur = umur;
    }
    //public method untuk menampilkan info()
    public void tampilkanInfo() {
        System.out.println("INFORMASI PERSON");
        System.out.println("Nama    :" +nama);
        System.out.println("Umur    :" +umur);
        System.out.println("Alamat  :" +alamat);
        System.out.println("Telepon :" +telepon);
        System.out.println("Email   :" +email);
    }

    //private method- hanya bisa dipanggil di dalam class ini
    private void methodPribadi(){
        System.out.println("ini adalah method private");
    }

    //protected method
    protected void methodProtected(){
        System.out.println("ini adalah method protected");
    }
    //method untuk mengakses private method
    public void PanggilMethodPribadi() {
        methodPribadi(); //ok- dalam class yang sama
    }
}