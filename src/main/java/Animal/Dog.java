package Animal;

/**
 * Created by Slavka Dontsov on 02.07.2017.
 */
public class Dog extends Pet{
    
    private static final String VARIETY_PET = "Dog";

    /*
    * Конструктор класс Собака
     */
    public Dog(final String id, final String petName){
        super(id, petName);
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
