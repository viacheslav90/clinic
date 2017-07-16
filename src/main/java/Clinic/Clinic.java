package Clinic;

import Client.Client;
import JsonConverter.JsonConverter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
    private static Clinic cliicInstance;
    private static String clinicJsonFile = "clinic.json";
    private static final Logger logger = Logger.getLogger(Client.class.toString());

    public Clinic() {
        this.clients = new ArrayList<Client>();
        this.clients = this.readClinicFromJson(clinicJsonFile);
        System.out.println(this.clients);
        logger.info("Clinic has been created");
    }

    /*
    * Метод возвращает статический обьект клиники
     */
    public static Clinic getClinicInstance(){
        if (cliicInstance == null) {
            logger.info("Clinic instance has been created");
            return cliicInstance = new Clinic();
        }
        return cliicInstance;
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
        logger.info("Client has been added to clinic");
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
    public  Client findClientById(final String name) {
        for (int i = 0; i < this.clients.size() - 1; i++)
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

    public ArrayList<Client> getClientArrayList(){
        return this.clients;
    }

    private ArrayList<Client> readClinicFromJson(String file){
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String clientsJson  = reader.readLine();
            Gson gson = new Gson();
            JsonElement jsonElement = gson.fromJson (clientsJson, JsonElement.class);
            System.out.println(jsonElement);
            JsonConverter jsonConverter = new JsonConverter();
            clients = jsonConverter.deserialize(jsonElement, new TypeToken<ArrayList<Client>>(){}.getType(), null);
            logger.info("Clients list has been read from clinic.json");
        } catch (FileNotFoundException e){
            e.getStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clients;
    }
}