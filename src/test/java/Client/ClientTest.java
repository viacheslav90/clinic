package Client;

import Pet.Pet;
import PetFactory.PetFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {

    private PetFactory petFactory = new PetFactory();
    private Pet pet = petFactory.getPet("Dog", "John", "Doggy");
    private Client client = new Client("John", pet);

    @Test
    public void getPet() throws Exception {
        assertEquals(this.client.getPet(), this.pet);
    }
}