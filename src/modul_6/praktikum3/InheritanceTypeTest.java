package modul_6.praktikum3;

public class InheritanceTypeTest {
    public static void main(String[] args) {
        //multilevel inheritance test
        Dog dog = new Dog("Buddy", "Brown", "Golden Retriever");
        dog.eat();
        dog.sleep();
        dog.giveBirth();
        dog.bark();

        System.out.println();

        Cat cat = new Cat("whiskers", "white", true)
        cat.eat();
        cat.sleep();
        cat.giveBirth();
        cat.meow();

        System.out.println();

        Animal[] animals = {new Dog("max", "Black", "Labrador");
        new Cat("luna", "Gray", false)};

        for (Animal animal : animals) {
            animal.eat();
        }
    }
}