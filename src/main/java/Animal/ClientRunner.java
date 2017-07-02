package Animal;

/**
 * Created by Slavka Dontsov on 02.07.2017.
 */
public class ClientRunner {

    public static void main(String[] args){
        final Clinic clinic = new Clinic(10);

        clinic.addClient(0, new Client("Bwrown"), new Cat("Diggy"));
    }

}
