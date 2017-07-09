package JSONParser;


import Pet.Pet;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by Slavka Dontsov on 09.07.2017.
 */
public class PetParser {
    private String clientName;
    private String petName;
    private String petSubClass;

    public String petToJSON (Pet pet) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(pet);
    }
}
