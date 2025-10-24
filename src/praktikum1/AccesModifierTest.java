package praktikum1;

public class AccesModifierTest {
    public static void main(String[] args) {
        Person person = new Person("Muna nafisa", 19);

        //test akses public
        person.email = "munanafisa2gmail.com"; //ok- public
        System.out.println("email:" + person.email);

        //test akses default (dalam package yang sama)
        person.alamat="bandung";
        System.out.println("alamat:" + person.alamat);

        //test akses protected (dalam package yang sama)
        person.telepon="081234567891";
        System.out.println("telepon:" + person.telepon);

        //test akses privat - AKAN ERROR jika uncomment
        //person.nama = "jeje";     //ERROR- private
        //person.umur = 50;         //ERROR- private
        //person.methosPribadi();   //ERROR- private

        //mengakses data private melalui public method
        person.tampilkanInfo();

        //mengakses private method melalui public method
        person.PanggilMethodPribadi();

        System.out.println("\nDEMONTRASI ACCES MODIFIER");
        System.out.println("✅ public    :Bisa diakses");
        System.out.println("✅ Default   :Bisa diakses (dalam package yang sama)");
        System.out.println("✅ Protected :Bisa diakses(dalam package yang sama)");
        System.out.println("❌ Private   :TIDAK bisa diakses langsung");
    }
}
