package Frames;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Slavka Dontsov on 04.07.2017.
 */
public class AddClientFrame extends JFrame {

    public AddClientFrame(){
        super("Add new Client");
        this.createAddClientFrame();
    }

    private void createAddClientFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setVisible(true);

        JPanel upperPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        this.add(upperPanel);
        this.add(bottomPanel);
        upperPanel.setLayout(new FlowLayout());
        bottomPanel.setLayout(new FlowLayout());

        JTextField clientNameTextField = new JTextField();
        clientNameTextField.setSize(300, 80);
        upperPanel.add(clientNameTextField);
        //add(clientNameTextField);

        JTextField petNameTextField = new JTextField();
        upperPanel.add(petNameTextField);

        JButton addButton = new JButton("Add");
        bottomPanel.add(addButton);

        JButton cancelButton = new JButton("Cancel");
        bottomPanel.add(cancelButton);
    }

    public static void main(String[] args){

        AddClientFrame addClientFrame = new AddClientFrame();

    }
}


