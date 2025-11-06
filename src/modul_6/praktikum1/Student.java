package modul_6.praktikum1;

public class Student extends Person {
    private String StudentId;

    public Student(String name, int age, String StudentId) {
        super(name, age);
        this.StudentId = StudentId;
    }

    public void study() {
        System.out.println(name + "is studying.");
    }

    @Override
    public void greet() {
        System.out.println("Hello, i am a student named " + name);
    }
}
