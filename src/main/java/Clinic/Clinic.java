package Clinic;

import Client.Client;

/**
 * Hello world!
 *
 */
public class Clinic {

    /**
     * Список клиентов
     */
    private final Client[] clients;

    public Clinic(final int size) {
        this.clients = new Client[size];
    }

    /*
    *   Добавить клиента
    *   @param position Позиция
    *   @param client Клиент
     */
    public void addClient(final int position, final Client client) {
        this.clients[position] = client;

    }

    /*
    \* Найти клиента по имени питомца
    *  @param name Кличка питомца
     */
    public Client findClientByPetName(final String name) {
        for (int i = 0; i < this.clients.length - 1; i++)
            if (clients[i].getPetName().compareTo(name) == 0)
                return clients[i];
        System.out.println("Клиента с таким питомцем нет в клинике");
        return new Client();
    }

    /*
    * Найти клиента по имени
    * @param Имя клиента
     */
    public Client findClientById(final String name) {
        for (int i = 0; i < this.clients.length - 1; i++)
            if (clients[i].getId().compareTo(name) == 0) {
                return clients[i];
            }
        System.out.println("Клиента с таким именем нет в клинике");
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
        return clientsList;
    }
}