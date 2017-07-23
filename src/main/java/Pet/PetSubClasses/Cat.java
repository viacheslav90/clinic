package Pet.PetSubClasses;

import Pet.Pet;
import jdk.nashorn.internal.runtime.options.LoggingOption;

import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 02.07.2017.
 */
public class Cat extends Pet{

    private static final Logger logger = Logger.getLogger(Cat.class.getName());
    private static final String VARIETY_PET = "Cat";

    /*
    *Конструктор класса Кот
     */
    public Cat(final String id, final  String petName){
        super(id, petName);
        logger.info("Object Cat: Cat name: '" + petName + "' Client name '" + id + "' has been created");
    }

    /*
    * Голос животного
     */
    @Override
    public String getVoice() {
        logger.info("getVoice() method has been called");
        return "Мяу-мяу";
    }

    /*
    * Получениче разновидности животного
     */
    public String getVarietyPet(){
        logger.info("getVerietyPet() has been called");
        return VARIETY_PET;
    }

    public boolean equals(Object obj){
        if(obj == this)
            return true;
        if (obj == null)
            return false;
        Cat cat = (Cat) obj;
        if (cat.getClientName() == null || cat.getVarietyPet() == null || cat.getPetName() == null)
            return false;
        if (!this.clientName.equals(cat.getClientName()))
            return false;
        if (!this.petName.equals(cat.getPetName()))
            return false;
        if (!VARIETY_PET.equals(cat.getVarietyPet()))
            return false;
        return true;
    }
}
