package Clinic;

import Client.Client;

import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class Clinic {

    /**
     * Список клиентов
     */
    private final Client[] clients;

    private static final Logger logger = Logger.getLogger(Client.class.toString());

    public Clinic(final int size) {
        this.clients = new Client[size];
        logger.info("Clinic with size: " + size + " has been created");
    }

    /*
    *   Добавить клиента
    *   @param position Позиция
    *   @param client Клиент
     */
    public void addClient(final int position, final Client client) {
        this.clients[position] = client;
        logger.info("Client has been added to " + position + " position");
    }

    /*
    \* Найти клиента по имени питомца
    *  @param name Кличка питомца
     */
    public Client findClientByPetName(final String petName) {
        for (int i = 0; i < this.clients.length - 1; i++)
            if (clients[i].getPetName().compareTo(petName) == 0){
                logger.info("Client " + clients[i].getId() + "was found. His pet name is: " + clients[i].getPetName());
                return clients[i];
            }
        logger.info("Client with such name was not found");
        return new Client();
    }

    /*
    * Найти клиента по имени
    * @param Имя клиента
     */
    public Client findClientById(final String name) {
        for (int i = 0; i < this.clients.length - 1; i++)
            if (clients[i].getId().compareTo(name) == 0) {
                logger.info("Client " + clients[i].getId() + "was found. His pet name is: " + clients[i].getPetName());
                return clients[i];
            }
        logger.info("Client with such name was not found");
        return new Client();
    }

    /*
    * Получить список клиенвов
     */
    public String[] getClients(){
        String[] clientsList = new String[100];
        for (int i = 0; i < this.clients.length - 1; i++){
            String clientName = "Клиент: " + this.clients[i].getId() + " - " + this.clients[i].getPetName();
            clientsList[i] = clientName;
        }
        logger.info("List of clients was displayed");
        return clientsList;
    }
}