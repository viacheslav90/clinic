package Client;

import Pet.Pet;

/**
 * Created by Slavka Dontsov on 02.07.2017.
 */
public class Client {

    private final String id;
    private final Pet pet;

    public Client(){
        this.id = null;
        this.pet = null;
    }

    public Client(final String id, final Pet pet){
        this.id = id;
        this.pet = pet;
    }

    /*
    * Получить имя клиента
     */
    public String getId(){
        return this.id;
    }

    /*
    * Получить кличку животного клиента
     */
    public String getPetName(){
        return this.pet.getPetName();
    }

}
