package Clinic;

import Client.Client;
import JsonConverter.JsonConverter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Класс клиника
 *
 */
public class Clinic {

    /**
     * Список клиентов
     */
    private ArrayList<Client> clients;
    private static Clinic clinicInstance;
    private static String clinicJsonFile = "clinic.json";
    private static final Logger logger = Logger.getLogger(Client.class.toString());

    public Clinic() {
        this.clients = new ArrayList<Client>();
        this.clients = this.readClinicFromJson(clinicJsonFile);
        logger.info("Clinic has been created");
    }

    /*
    * Метод возвращает статический обьект клиники
     */
    public static Clinic getClinicInstance(){
        if (clinicInstance == null) {
            logger.info("Clinic instance has been created");
            return clinicInstance = new Clinic();
        }
        return clinicInstance;
    }

    public ArrayList<Client> getClientsArray(){
        return clients;
    }

    /*
    *   Добавить клиента
    *   @param position Позиция
    *   @param client Клиент
     */
    public void addClient(final Client client) {
        this.clients.add(client);
        this.writeToJson();
        logger.info("Client has been added to clinic");
    }

    public boolean deleteClient(String clientName){
        Client client = this.findClientById(clientName);
        if(!client.equals(new Client())){
            this.clients.remove(client);
            this.writeToJson();
            return true;
        }
        return false;
    }

    /*
    \* Найти клиента по имени питомца
    *  @param name Кличка питомца
     */
    public Client findClientByPetName(final String petName) {
        for (int i = 0; i < this.clients.size() - 1; i++)
            if (this.clients.get(1).getPetName().compareTo(petName) == 0){
                logger.info("Client " + this.clients.get(i).getId() + "was found. His pet name is: " + this.clients.get(i).getPetName());
                return this.clients.get(i);
            }
        logger.info("Client with such name was not found");
        return new Client();
    }

    /*
    * Найти клиента по имени
    * @param Имя клиента
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

    /*
    * Получить список клиенвов
     */
    public String[] getClients(){
        String[] clientsList = new String[100];
        for (int i = 0; i < this.clients.size() - 1; i++){
            String clientName = "Клиент: " + this.clients.get(i).getId() + " - " + this.clients.get(i).getPetName();
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

    public boolean isExist(String clientName) {
        for (int i = 0; i < this.clients.size(); i++) {
            if (clientName.equals(clients.get(i).getId()))
                return true;
        }
        return false;
    }

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