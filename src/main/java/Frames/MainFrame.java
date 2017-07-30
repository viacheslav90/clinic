package Frames;

import ActionListeners.MainScreenActionListeners.*;

import javax.swing.*;
import java.awt.*;

import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 03.07.2017.
 */
public class MainFrame extends JFrame {

    private static final Logger logger = Logger.getLogger(MainFrame.class.toString());

    public MainFrame(){
        super("My Clinic");
        createMainFrame();
        logger.info("Main frame was build");
    }

    public void createMainFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setSize(900,200);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setVisible(true);

        JPanel jPanel = new JPanel();
        this.add(jPanel);
        jPanel.setLayout(new FlowLayout());

        JButton addClientButton = new JButton("Add Client");
        jPanel.add(addClientButton);

        JButton deleteClientButton = new JButton("Delete Client");
        jPanel.add(deleteClientButton);
        deleteClientButton.addActionListener(new DeleteClientActionListener());

        JButton showClientsButton = new JButton("Show Clients");
        jPanel.add(showClientsButton);
        showClientsButton.addActionListener(new ShowClientsActionListener());

        JButton searchByNameButton = new JButton("Search Client by name");
        jPanel.add(searchByNameButton);
        searchByNameButton.addActionListener(new SearchByNameActionListener());

        JButton searchByPetButton = new JButton("Search Client by pet");
        jPanel.add(searchByPetButton);
        searchByPetButton.addActionListener(new SearchByPetActionListener());

        AddClientActionListener addButtonListener = new AddClientActionListener();
        addClientButton.addActionListener(addButtonListener);

        this.pack();

        logger.info("Main frame was opened");
    }

    public static void main(String[] args) {

        MainFrame mainFrame = new MainFrame();
    }
}
