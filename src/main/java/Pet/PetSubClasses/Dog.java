package Pet.PetSubClasses;

import Pet.Pet;

import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 02.07.2017.
 */
public class Dog extends Pet{

    private static final Logger logger = Logger.getLogger(Dog.class.toString());
    private static final String VARIETY_PET = "Dog";

    /*
    * Конструктор класс Собака
     */
    public Dog(final String id, final String petName){
        super(id, petName);
        logger.info("New object Dog was created. id: " + id + ", pet name: " + petName);
    }

    /*
    * Голос животного
     */
    @Override
    public String getVoice(){
        return "Гав-гав";
    }

    /*
    * Получение разновидности животного
     */
    public String getVarietyPet(){
        return VARIETY_PET;
    }
}
