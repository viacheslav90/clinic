package Animal;

/**
 * Hello world!
 *
 */
public class Clinic {

    /**
     * Список клиентов
      */
    private final Client[] clients;

    public Clinic(final int size){
        this.clients = new Client[size];
    }

    /*
    *   Добавить клиента
    *   @param position Позиция
    *   @param client Клиент
     */
    public void addClient(final int position, final Client client){
        this.clients[position] = client;
    }

    /*
    \* Найти клиента по имени питомца
    *  @param name Кличка питомца
     */
    public Client[] findClientByPetName(final String name){
        //TODO
        return new Client[]{};
    }
}
