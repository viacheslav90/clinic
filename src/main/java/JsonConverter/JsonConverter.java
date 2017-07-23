package JsonConverter;

import Client.Client;
import Clinic.Clinic;
import Pet.Pet;
import PetFactory.IPetFactory;
import PetFactory.PetFactory;
import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Slavka Dontsov on 15.07.2017.
 */
public class JsonConverter implements JsonSerializer<Clinic>, JsonDeserializer<ArrayList<Client>> {

    public ArrayList<Client> deserialize(final JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonArray jsonArray= jsonElement.getAsJsonArray();
        ArrayList<Client> clients = new ArrayList<Client>();

        for (int i = 0; i < jsonArray.size(); i++){
            JsonObject clientObj = jsonArray.get(i).getAsJsonObject();
            String clientName = clientObj.get("client_name").getAsString();
            JsonObject petObj = clientObj.get("pet").getAsJsonObject();
            String petName = petObj.get("pet_name").getAsString();
            String petSubclass = petObj.get("pet_subclass").getAsString();
            IPetFactory petFactory = new PetFactory();
            Pet newPet = petFactory.getPet(petSubclass, clientName, petName);
            Client newClient = new Client(clientName, newPet);
            clients.add(newClient);
        }
        return clients;
    }


    public JsonElement serialize(final Clinic clinic, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonArray clinicObj = new JsonArray();

        ArrayList<Client> clientArrayList = clinic.getClientsArray();

        for (Client client : clientArrayList) {
            JsonObject clientObj = new JsonObject();
            clientObj.addProperty("client_name", client.getId());
            JsonObject petObj = new JsonObject();
            petObj.addProperty("pet_name", client.getPetName());
            petObj.addProperty("pet_subclass", client.getPet().getVarietyPet());
            clientObj.add("pet", petObj);
            clinicObj.add(clientObj);
        }
        return clinicObj;
    }
}
