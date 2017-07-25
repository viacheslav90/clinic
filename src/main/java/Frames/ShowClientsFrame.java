package Frames;

import ActionListeners.MainScreenActionListeners.WindowCloseListener;
import Clinic.Clinic;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class ShowClientsFrame extends JFrame{

    private static final Logger logger = Logger.getLogger(ShowClientsFrame.class.toString());

    public ShowClientsFrame(){
        super("Clients");
        this.createShowClientsFrame();
        WindowCloseListener windowCloseListener = new WindowCloseListener();
        this.addWindowListener(windowCloseListener);
        logger.info("Show clients frame has been build");
    }

    private void createShowClientsFrame(){

        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setMaximumSize(new Dimension(10,10));

        BorderLayout layout = new BorderLayout();

        JPanel clientsPannel = new JPanel(layout);
        this.add(clientsPannel);

        JTextArea clientsTextArea = new JTextArea();
        clientsTextArea.setEditable(false);
        clientsPannel.add(clientsTextArea, BorderLayout.WEST);

        final JScrollPane clientScrollPane = new JScrollPane(clientsTextArea);
        clientScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        clientsPannel.add(clientScrollPane, BorderLayout.EAST);

        Clinic clinic = Clinic.getClinicInstance();
        String[] clientsArray = clinic.getClients();

        for (String client : clientsArray){
            if (client == null)
                break;
            clientsTextArea.append(client + "\n");
        }

        this.pack();
        this.setVisible(true);
    }
}
