package Client;

import Pet.Pet;
import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 02.07.2017.
 */
public class Client {

    // creating Logger instance
    private static final Logger logger = Logger.getLogger(Client.class.toString());
    // client name
    private final String id;
    // client pet
    private Pet pet = null;

    // Client default constructor
    public Client(){
        this.id = null;
        this.pet = null;
        logger.info("Empty object Client was created");
    }

    // Client constructor
    public Client(final String id, final Pet pet){
        this.id = id;
        this.pet = pet;
        logger.info("Client object was created. id: " + id + " , Pet: " + pet.getPetName());
    }

    // getter client name
    public String getId(){
        return this.id;
    }

    // getter client pet name
    public String getPetName(){
        return this.pet.getPetName();
    }

    // getter client pet
    public Pet getPet(){
        return this.pet;
    }

    // overriding equals method
    @Override
    public boolean equals(Object obj){
        if(obj == this)
            return true;
        if (obj.getClass() != this.getClass() )
            return false;
        Client client = (Client)obj;
        if (client.getId() == null || client.getPet() == null)
            return false;
        if (!client.getId().equals(this.getId()))
            return false;
        if (!client.getPet().equals(this.getPet())){
            return true;
        }
        return false;
    }

    // overriding toString method
    @Override
    public String toString(){
        String client = "Client: " + this.getId() + " - Pet variety: " + this.getPet().getVarietyPet() + " - Pet name: " + this.getPet().getPetName();
        return client;
    }
}
