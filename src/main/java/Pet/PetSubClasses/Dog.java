package Pet.PetSubClasses;

import Pet.Pet;

import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 02.07.2017.
 */
public class Dog extends Pet{

    private static final Logger logger = Logger.getLogger(Dog.class.toString());
    private static final String VARIETY_PET = "Dog";

    public Dog(final String id, final String petName){
        super(id, petName);
        logger.info("New object Dog was created. id: " + id + ", pet name: " + petName);
    }

    @Override
    public String getVoice(){
        return "Гав-гав";
    }

    public String getVarietyPet(){
        return VARIETY_PET;
    }

    public boolean equals(Object obj){
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        Dog dog = (Dog) obj;
        if (dog.getClientName() == null || dog.getPetName() == null || dog.getVarietyPet() == null)
            return false;
        if (!super.clientName.equals(dog.getClientName()))
            return false;
        if (!super.petName.equals(dog.getPetName()))
            return false;
        if (!VARIETY_PET.equals(dog.getVarietyPet()))
            return false;
        return true;
    }
}
