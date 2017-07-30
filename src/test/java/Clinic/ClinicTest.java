package Clinic;

import Client.Client;
import Pet.PetSubClasses.Cat;
import Pet.PetSubClasses.Dog;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class ClinicTest {
    @Test
    public void addClient() throws Exception {
        Clinic clinic = Clinic.getClinicInstance();
        Client client = new Client("John", new Cat("John", "Katty"));
        clinic.addClient(client);
        ArrayList<Client> clientsArray = clinic.getClientsArray();
        for (Client c : clientsArray) {
           assertEquals(c, client);
        }
        clinic.deleteClient("John");
    }

    @Test
    public void deleteClient() throws Exception {
        Clinic clinic = Clinic.getClinicInstance();
        Client client = new Client("John", new Cat("John", "Katty"));
        clinic.addClient(client);
        clinic.deleteClient("John");
        ArrayList<Client> clientsArray = clinic.getClientsArray();
        Client resultClient = null;
        for (Client c : clientsArray){
            if (c.equals(resultClient))
                resultClient = c;
        }
        assertNull(resultClient);
    }

    @Test
    public void isExist() throws Exception {
        Clinic clinic = Clinic.getClinicInstance();
        Dog dog = new Dog("John", "Katty");
        Client existClient = new Client("John", dog);
        Client notExistclient = new Client("Black", new Dog("John", "Katty"));
        clinic.addClient(existClient);
        Boolean isExistsTrue = clinic.isExist(existClient.getId());
        assertTrue(isExistsTrue);
        Boolean isExistsFalse = clinic.isExist(notExistclient.getId());
        assertFalse(isExistsFalse);
        clinic.deleteClient("John");
    }

    @Test
    public void writeToJson() throws Exception {
        String json = "[{\"client_name\":\"John\",\"pet\":{\"pet_name\":\"Katty\",\"pet_subclass\":\"Cat\"}}]";
        String readedJson = "";
        Clinic clinic = Clinic.getClinicInstance();
        Client client = new Client("John", new Cat("John", "Katty"));
        clinic.addClient(client);
        clinic.writeToJson();

        File file = new File("clinic.json");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String readedFromFile = "";
        while ((readedFromFile = br.readLine()) != null){
            readedJson += readedFromFile;
        }
        assertEquals(json, readedJson);
        clinic.deleteClient("John");
    }

}