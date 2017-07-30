package PetFactory;

import Pet.Pet;
import Pet.PetSubClasses.Cat;
import Pet.PetSubClasses.Dog;

import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 04.07.2017.
 */
public class PetFactory implements IPetFactory{

    private static final Logger logger = Logger.getLogger(PetFactory.class.toString());

    public Pet getPet(String petSubClass, String clientName, String petName) {
        if(petSubClass.equals("Cat")){
            logger.info("Class PetFactory returns new Cat. Pet name: " + petName + ", client name: " + clientName);
            return new Cat(clientName, petName);
        }
        if (petSubClass.equals("Dog")){
            logger.info("Class PetFactory returns new Dog. Pet name: " + petName + ", client name: " + clientName);
            return new Dog(clientName, petName);
        }
        else{
            logger.info("Class PetFactory returns null");
            return null;
        }
    }
}
