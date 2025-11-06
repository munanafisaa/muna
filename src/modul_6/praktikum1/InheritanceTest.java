package modul_6.praktikum1;

public class InheritanceTest {
    public static void main(String [] args) {
        Student student = new Student("Alice", 20, "S12345");

        //memanggil method dari superclass
        student.displayInfo();

        //memanggil method dari subclass
        student.study();

        //memanggil overriden meyhod
        student.greet();

        //polymorphism: student sebagai person
        Person person = new Student("Bob",22, "S7890");
        person.greet();
    }
}
