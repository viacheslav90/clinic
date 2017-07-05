package Client;

import Pet.Pet;
import sun.rmi.runtime.Log;

import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 02.07.2017.
 */
public class Client {

    private static final Logger logger = Logger.getLogger(Client.class.toString());
    private final String id;
    private final Pet pet;

    public Client(){
        this.id = null;
        this.pet = null;
        logger.info("Empty object Client was created");
    }

    public Client(final String id, final Pet pet){
        this.id = id;
        this.pet = pet;
        logger.info("Client object was created. id: " + id + " , Pet: " + pet.getPetName());
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
