package example;

public class AnimalsFactory {

    public static final String catFactory = "cat";
    public static final String dogFactory = "dog";

    public static Animals createAnimals(String factory) {
        if (factory == null) {
            return  null;
        }
        switch (factory) {
            case catFactory :
                return new Cat();
            case dogFactory:
                return new Dog();
            default:
                return null;
        }
    }
}
