package PetFactory;

import Pet.Pet;

/**
 * Created by Slavka Dontsov on 04.07.2017.
 */
public interface IPetFactory {

    public Pet getPet(String petSubClass, String clientName, String petName);

}
