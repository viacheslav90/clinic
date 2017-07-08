package Frames;

import ActionListeners.MainScreenActionListeners.WindowCloseListener;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 04.07.2017.
 */
public class AddClientFrame extends JFrame {

    private static final Logger logger = Logger.getLogger(AddClientFrame.class.toString());

    /*
    * Метод добавляет окно добавляения нового клиента
     */
    public AddClientFrame() {
        super("Add new Client");
        this.createAddClientFrame();
        WindowCloseListener windowCloseListener = new WindowCloseListener();
        this.addWindowListener(windowCloseListener);
        logger.info("Client frame was build");
    }

    /*
    * Метод отображает окно добавления нового клиента
     */
    private void createAddClientFrame() {
        //setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setVisible(true);

        JPanel jpanel = new JPanel();
        this.add(jpanel);
        jpanel.setLayout(new FlowLayout());

        JTextField clientNameTextField = new JTextField("", 15);
        clientNameTextField.setHorizontalAlignment(JTextField.LEFT);
        jpanel.add(clientNameTextField);

        JTextField petNameTextField = new JTextField("", 15);
        petNameTextField.setHorizontalAlignment(JTextField.LEFT);
        jpanel.add(petNameTextField);

        JButton addButton = new JButton("Add");
        jpanel.add(addButton);

        JButton cancelButton = new JButton("Cancel");
        jpanel.add(cancelButton);

        logger.info("Client windod was opened");
    }
}


