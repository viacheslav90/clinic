package Frames;

import ActionListeners.MainScreenActionListeners.WindowCloseListener;
import Client.Client;
import Clinic.Clinic;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class SearchClientByPetFrame extends JFrame{

    Logger logger = Logger.getLogger(SearchClientByPetFrame.class.toString());

    public SearchClientByPetFrame(){
        super("Search client by pet name");
        this.createSearchClientByPetFrame();
        this.setSize(500,200);
        this.setVisible(true);
        this.addWindowListener(new WindowCloseListener());
        logger.info("SearchClientByPetFrame has been build");
    }

    private void createSearchClientByPetFrame(){
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);

        final JPanel searchClientByPetPanel = new JPanel(new FlowLayout());
        this.add(searchClientByPetPanel, BorderLayout.NORTH);

        final JLabel petNameLabel = new JLabel("Enter pet name");
        searchClientByPetPanel.add(petNameLabel);

        final JPanel resultPanel = new JPanel();
        this.add(resultPanel, BorderLayout.SOUTH);

        final JTextArea searchedClientTextArea = new JTextArea();
        searchedClientTextArea.setEditable(false);
        searchedClientTextArea.setVisible(false);
        resultPanel.add(searchedClientTextArea);

        final JTextField petNameTextField = new JTextField("", 15);
        searchClientByPetPanel.add(petNameTextField);
        petNameTextField.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                searchedClientTextArea.setText("");
                searchedClientTextArea.setVisible(false);
            }
        });

        JButton searchButton = new JButton("Search");
        searchClientByPetPanel.add(searchButton);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String petName = petNameTextField.getText();
                if(petName.equals(""))
                    JOptionPane.showMessageDialog(searchClientByPetPanel, "Please enter pet name");
                else {
                    Clinic clinic = Clinic.getClinicInstance();
                        Client client = clinic.findClientByPetName(petName);
                    if(client.getId() != null && client.getPet() != null) {
                        searchedClientTextArea.setText(client.toString());
                        searchedClientTextArea.setVisible(true);
                    } else
                        JOptionPane.showMessageDialog(searchClientByPetPanel, "There is no client with such pet in clinic");
                }
            }
        });
    }
}