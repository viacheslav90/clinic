package Animal;

/**
 * Created by Slavka Dontsov on 02.07.2017.
 */
public class ClientRunner {

    public static void main(String[] args){
        final Clinic clinic = new Clinic(100);

        clinic.addClient(0, new Client("Brown"), new Cat("Diggy"));
    }

}
