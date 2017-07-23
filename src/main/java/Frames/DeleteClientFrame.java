package Frames;

import ActionListeners.MainScreenActionListeners.WindowCloseListener;
import Clinic.Clinic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 17.07.2017.
 */

public class DeleteClientFrame extends JFrame {

    private static Logger logger = Logger.getLogger(DeleteClientFrame.class.toString());

    public DeleteClientFrame() {
        super("Delete Client");
        this.createDeleteClientFrame();
        WindowCloseListener windowCloseListener = new WindowCloseListener();
        this.addWindowListener(windowCloseListener);
        logger.info("Delete Client Frame has been build");
    }

    private void createDeleteClientFrame() {
        setAlwaysOnTop(true);
        //setSize(1000, 500);
        setVisible(true);
        setLocationRelativeTo(null);

        JPanel deleteClientPanel = new JPanel(new FlowLayout());
        this.add(deleteClientPanel);

        JLabel clientNameLabel = new JLabel("Enter Client name");
        deleteClientPanel.add(clientNameLabel);

        final JTextField clientNameTextField = new JTextField("", 15);
        deleteClientPanel.add(clientNameTextField);

        JButton deleteButton = new JButton("Delete");
        deleteClientPanel.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame infoFrame = new JFrame();
                infoFrame.setAlwaysOnTop(true);
                if (clientNameTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(infoFrame, "Please enter Client name");
                }
                else {
                    Clinic clinic = Clinic.getClinicInstance();
                    if (clinic.isExist(clientNameTextField.getText())) {
                        clinic.deleteClient(clientNameTextField.getText());
                        JOptionPane.showMessageDialog(infoFrame, "Client successfully deleted");
                    } else
                        JOptionPane.showMessageDialog(infoFrame, "Client with such name does not exists");
                }
            }
        });

        this.pack();

    }
}
