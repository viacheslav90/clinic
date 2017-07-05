package Frames;

import ActionListeners.MainScreenActionListeners.AddClientActionListener;

import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 03.07.2017.
 */
public class MainFrame extends JFrame {

    private static final Logger logger = Logger.getLogger(MainFrame.class.toString());

    /*
    * Метод добавляет основное меню
    */
    public MainFrame(){
        super("My Clinic");
        createMainFrane();
        logger.info("Main frame was build");
    }

    /*
    * Метод отображает основное меню
     */
    public void createMainFrane() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900,200);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setVisible(true);

        JPanel jPanel = new JPanel();
        this.add(jPanel);
        jPanel.setLayout(new FlowLayout());

        JButton addClientButton = new JButton("Add Client");
        jPanel.add(addClientButton);
        AddClientActionListener addButtonListener = new AddClientActionListener();
        addClientButton.addActionListener(addButtonListener);

        JButton deleteClientButton = new JButton("Delete Client");
        jPanel.add(deleteClientButton);

        JButton showClientsButton = new JButton("Show Clients");
        jPanel.add(showClientsButton);

        JButton searchByNameButton = new JButton("Search Client by name");
        jPanel.add(searchByNameButton);

        JButton searchByPetButton = new JButton("Search Client by pet");
        jPanel.add(searchByPetButton);

        ActionListener addClientButtonListener = (ActionListener) new AddClientActionListener();
        addClientButton.addActionListener(addClientButtonListener);

        logger.info("Main frame was opened");
    }

    public static void main(String[] args) {

        MainFrame mainFrame = new MainFrame();
    }
}
