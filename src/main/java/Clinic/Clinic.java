package Clinic;

import Client.Client;
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
    private static ArrayList<Client> clients;
    private static Clinic cliicInstance;

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

    private static final Logger logger = Logger.getLogger(Client.class.toString());

    public Clinic() {
        clients = new ArrayList<Client>();
        logger.info("Clinic has been created");
    }

    /*
    *   Добавить клиента
    *   @param position Позиция
    *   @param client Клиент
     */
    public static void addClient(final Client client) {
        clients.add(client);
        logger.info("Client has been added to clinic");
    }

    /*
    \* Найти клиента по имени питомца
    *  @param name Кличка питомца
     */
    public static Client findClientByPetName(final String petName) {
        for (int i = 0; i < clients.size() - 1; i++)
            if (clients.get(1).getPetName().compareTo(petName) == 0){
                logger.info("Client " + clients.get(i).getId() + "was found. His pet name is: " + clients.get(i).getPetName());
                return clients.get(i);
            }
        logger.info("Client with such name was not found");
        return new Client();
    }

    /*
    * Найти клиента по имени
    * @param Имя клиента
     */
    public static Client findClientById(final String name) {
        for (int i = 0; i < clients.size() - 1; i++)
            if (clients.get(i).getId().compareTo(name) == 0) {
                logger.info("Client " + clients.get(i).getId() + "was found. His pet name is: " + clients.get(i).getPetName());
                return clients.get(i);
            }
        logger.info("Client with such name was not found");
        return new Client();
    }

    /*
    * Получить список клиенвов
     */
    public static String[] getClients(){
        String[] clientsList = new String[100];
        for (int i = 0; i < clients.size() - 1; i++){
            String clientName = "Клиент: " + clients.get(i).getId() + " - " + clients.get(i).getPetName();
            clientsList[i] = clientName;
        }
        logger.info("List of clients was displayed");
        return clientsList;
    }
}