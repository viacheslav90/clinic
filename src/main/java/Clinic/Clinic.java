package Clinic;

import Client.Client;
import JsonConverter.JsonConverter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;

// class Clinic
public class Clinic {

    private ArrayList<Client> clients;
    private static Clinic clinicInstance;

    //path to json file
    private static String clinicJsonFile = "clinic.json";
    // create Logger instance
    private static final Logger logger = Logger.getLogger(Client.class.toString());

    // Clinic constructor
    public Clinic() {
        this.clients = new ArrayList<Client>();
        this.clients = this.readClinicFromJson(clinicJsonFile);
        logger.info("Clinic has been created");
    }

    /**
     * clinic instance getter
     * @return clinicInstance
     */
    public static Clinic getClinicInstance(){
        if (clinicInstance == null) {
            logger.info("Clinic instance has been created");
            return clinicInstance = new Clinic();
        }
        return clinicInstance;
    }

    /**
     * clients array getter
     * @return ArrayList<Client>
     */
    public ArrayList<Client> getClientsArray(){
        return clients;
    }

    public void addClient(final Client client) {
        this.clients.add(client);
        this.writeToJson();
        logger.info("Client has been added to clinic");
    }

    /**
     * @param clientName
     * @return true if client was deleded, false if client was not found in clinic
     */
    public boolean deleteClient(String clientName){
        Client client = this.findClientById(clientName);
        if(!client.equals(new Client())){
            this.clients.remove(client);
            this.writeToJson();
            return true;
        }
        return false;
    }

    /**
     * find client by pet name
     * @param petName
     * @return Client
     */
    public Client findClientByPetName(final String petName) {
        for (int i = 0; i < this.clients.size(); i++)
            if (this.clients.get(i).getPetName().compareTo(petName) == 0){
                logger.info("Client " + this.clients.get(i).getId() + "was found. His pet name is: " + this.clients.get(i).getPetName());
                return this.clients.get(i);
            }
        logger.info("Client with such name was not found");
        return new Client();
    }


    /**
     * find client by name
     * @param name
     * @return Client
     */
    public Client findClientById(final String name) {
        for (int i = 0; i < this.clients.size(); i++)
            if (this.clients.get(i).getId().compareTo(name) == 0) {
                logger.info("Client " + this.clients.get(i).getId() + "was found. His pet name is: " + this.clients.get(i).getPetName());
                return this.clients.get(i);
            }
        logger.info("Client with such name was not found");
        return new Client();
    }

    /**
     * get clients
     * @return String[
     */
    public String[] getClients(){
        String[] clientsList = new String[100];
        for (int i = 0; i < this.clients.size(); i++){
            String clientName = clients.get(i).toString();
            clientsList[i] = clientName;
        }
        logger.info("List of clients was displayed");
        return clientsList;
    }


    private ArrayList<Client> readClinicFromJson(String file){

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String clientsJson  = reader.readLine();
            if(clientsJson == null){
                return new ArrayList<Client>();
            }
            Gson gson = new Gson();
            JsonElement jsonElement = gson.fromJson (clientsJson, JsonElement.class);
            JsonConverter jsonConverter = new JsonConverter();
            clients = jsonConverter.deserialize(jsonElement, new TypeToken<ArrayList<Client>>(){}.getType(), null);
            logger.info("Clients list has been read from clinic.json");
        } catch (FileNotFoundException e){
            e.getStackTrace();
            return new ArrayList<Client>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<Client>();
        }
        return clients;
    }

    /**
     * is exists
     * @param clientName
     * @return true which client is exist, false if client is not exists
     */
    public boolean isExist(String clientName) {
        for (int i = 0; i < this.clients.size(); i++) {
            if (clientName.equals(clients.get(i).getId()))
                return true;
        }
        return false;
    }

    // write to json file
    public void writeToJson() {
        JsonConverter clinicConverter = new JsonConverter();
        String clinicJson = clinicConverter.serialize(Clinic.getClinicInstance(), new TypeToken<Clinic>() {
        }.getType(), null).toString();
        try {
            FileWriter fileWriter = new FileWriter("clinic.json", false);
            fileWriter.write(clinicJson);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}