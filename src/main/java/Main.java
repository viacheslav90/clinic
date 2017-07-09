import Clinic.Clinic;
import Frames.MainFrame;

/**
 * Created by Slavka Dontsov on 04.07.2017.
 */
public class Main {

    public static void main(String[] args){

        Clinic clinic = Clinic.getClinicInstance();
        final MainFrame mainFrame = new MainFrame();
    }
}
