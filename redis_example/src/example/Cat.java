package example;

public class Cat implements Animals {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    public static void main(String[] args) {
        Animals cat = AnimalsFactory.createAnimals(AnimalsFactory.catFactory);
        Animals dog = AnimalsFactory.createAnimals(AnimalsFactory.dogFactory);
        cat.eat();
        dog.eat();
    }
}
