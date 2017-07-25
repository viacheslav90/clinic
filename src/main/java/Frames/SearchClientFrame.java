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

public class SearchClientFrame extends JFrame{

    Logger logger = Logger.getLogger(SearchClientFrame.class.toString());

    public SearchClientFrame(){
        super("Search client");
        this.createSearchClientFrame();
        this.setSize(500,200);
        this.setVisible(true);
        this.addWindowListener(new WindowCloseListener());
        logger.info("SearchClientFrame has been build");
    }

    private void createSearchClientFrame(){
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);

        final JPanel searchClientPanel = new JPanel(new FlowLayout());
        this.add(searchClientPanel, BorderLayout.NORTH);

        final JLabel clientNameLabel = new JLabel("Enter client name");
        searchClientPanel.add(clientNameLabel);

        final JPanel resultPanel = new JPanel();
        this.add(resultPanel, BorderLayout.SOUTH);

        final JTextArea searchedClientTextArea = new JTextArea();
        searchedClientTextArea.setEditable(false);
        searchedClientTextArea.setVisible(false);
        resultPanel.add(searchedClientTextArea);

        final JTextField clientNameTextField = new JTextField("", 15);
        searchClientPanel.add(clientNameTextField);
        clientNameTextField.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                searchedClientTextArea.setText("");
                searchedClientTextArea.setVisible(false);
            }
        });

        JButton searchButton = new JButton("Search");
        searchClientPanel.add(searchButton);
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String clientName = clientNameTextField.getText();
                if(clientName.equals(""))
                    JOptionPane.showMessageDialog(searchClientPanel, "Please enter client name");
                else {
                    Clinic clinic = Clinic.getClinicInstance();
                    if (clinic.isExist(clientName)) {
                        Client client = clinic.findClientById(clientName);
                        searchedClientTextArea.setText(client.toString());
                        searchedClientTextArea.setVisible(true);
                    } else
                        JOptionPane.showMessageDialog(searchClientPanel, "There is no client with such name in clinic");
                }
            }
        });
    }
}
