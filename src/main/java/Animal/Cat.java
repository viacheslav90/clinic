package Animal;

/**
 * Created by Slavka Dontsov on 02.07.2017.
 */
public class Cat extends Pet{

    private static final String VARIETY_PET = "Cat";

    /*
    *Конструктор класса Кот
     */
    public Cat(final String id, final  String petName){
        super(id, petName);
    }

    /*
    * Голос животного
     */
    @Override
    public String getVoice() {
        return "Мяу-мяу";
    }

    /*
    * Получениче разновидности животного
     */
    public String getVarietyPet(){
        return VARIETY_PET;
    }
}
