package Animal;

/**
 * Created by Slavka Dontsov on 02.07.2017.
 */
public class Cat extends Pet{

    private static Pet pet;

    /*
    *Конструктор класса Кот
     */
    public Cat(final Pet pet){
        this.pet = pet;
    }
}
