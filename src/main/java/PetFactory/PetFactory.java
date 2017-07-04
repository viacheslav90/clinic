package PetFactory;

import Pet.Pet;
import Pet.PetSubClasses.Cat;
import Pet.PetSubClasses.Dog;

/**
 * Created by Slavka Dontsov on 04.07.2017.
 */
public class PetFactory implements IPetFactory{

    public Pet getPet(String petSubClass, String clientName, String petName) {
        if(petSubClass == "Cat")
            return new Cat(clientName, petName);
        if (petSubClass == "Dog")
            return new Dog(clientName, petName);
        else
            return null;
    }
}
