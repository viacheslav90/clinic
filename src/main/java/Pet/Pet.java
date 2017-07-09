package Pet;

import Pet.PetSubClasses.Cat;

/**
 * Created by Slavka Dontsov on 02.07.2017.
 */
public abstract class Pet {

    private final String clientName;
    private final String petName;

    public Pet(final String clientName, final String petName){
        this.clientName = clientName;
        this.petName = petName;
    }

    public String getPetName(){
        return this.petName;
    }

    public String getClientName(){
        return this.clientName;
    }

    public abstract String getVarietyPet();

    public abstract String getVoice();

}
