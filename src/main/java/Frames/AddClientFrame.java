package Frames;

        import ActionListeners.MainScreenActionListeners.WindowCloseListener;
        import Client.Client;
        import Clinic.Clinic;
        import Pet.Pet;
        import PetFactory.PetFactory;
        import javax.swing.*;
        import javax.swing.event.CaretEvent;
        import javax.swing.event.CaretListener;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.ItemEvent;
        import java.awt.event.ItemListener;
        import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 04.07.2017.
 */
public class AddClientFrame extends JFrame {

    private static final Logger logger = Logger.getLogger(AddClientFrame.class.toString());
    private AddClientHandler addClientHandler;

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
        //setSize(1000, 500);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        setVisible(true);


        JPanel jpanel = new JPanel();
        this.add(jpanel);
        jpanel.setLayout(new FlowLayout());

        /*
        * Ввод имени клиента
         */
        final JLabel jLabelClientName = new JLabel("Client name: ");
        jLabelClientName.setVerticalAlignment(SwingConstants.CENTER);
        jLabelClientName.setHorizontalAlignment(SwingConstants.CENTER);
        jpanel.add(jLabelClientName);
        final JTextField clientNameTextField = new JTextField("", 15);
        clientNameTextField.setHorizontalAlignment(JTextField.LEFT);
        jpanel.add(clientNameTextField);
        jpanel.add(clientNameTextField);
        clientNameTextField.addCaretListener(new CaretListener(){
            public void caretUpdate(CaretEvent e) {
                addClientHandler.setClientName(clientNameTextField.getText());
            }
        });

        /*
        * Ввод имени питомца
         */
        final JLabel jLabelPetName = new JLabel("Pet name: ");
        jLabelPetName.setVerticalAlignment(SwingConstants.CENTER);
        jLabelPetName.setHorizontalAlignment(SwingConstants.CENTER);
        jpanel.add(jLabelPetName);
        final JTextField petNameTextField = new JTextField("", 15);
        petNameTextField.setHorizontalAlignment(JTextField.LEFT);
        jpanel.add(petNameTextField);
        petNameTextField.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent e) {
                addClientHandler.setPetName(petNameTextField.getText());
            }
        });

        /*
        * Выбор подкласса питомца
         */
        final JLabel jchoosePetSubClass = new JLabel("Choose pet subclass: ");
        jchoosePetSubClass.setHorizontalAlignment(SwingConstants.CENTER);
        jchoosePetSubClass.setVerticalAlignment(SwingConstants.CENTER);
        jpanel.add(jchoosePetSubClass);
        final String[] comboboxItems = {"Cat", "Dog"};
        final JComboBox jComboBox = new JComboBox(comboboxItems);
        jComboBox.setSelectedItem(comboboxItems[0]);
        jpanel.add(jComboBox);
        jComboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                addClientHandler.setPetSubClass(jComboBox.getSelectedItem().toString());
            }
        });

        /*
        * Кнопка добавить питомца
         */
        final JButton addButton = new JButton("Add");
        jpanel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(clientNameTextField.getText().length() != 0 && petNameTextField.getText().length() != 0)
                    addClientHandler.createNewClient();
            }
        });

        /*
        * Кнопка отменить
         */
        final JButton cancelButton = new JButton("Cancel");
        jpanel.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddClientFrame.this.dispose();
                Thread.currentThread().interrupt();
            }
        });

        addClientHandler = new AddClientHandler();
        this.pack();
        logger.info("addClientHandler has been created");
    }


    /*
    * Вложеный класс, который выполняет создание нового клиента
     */
    private class AddClientHandler {
        private String clientName;
        private String petName;
        private String petSubClass = "Cat";


        void setClientName(String clientName) {
            this.clientName = clientName;
            logger.info("Client name has been set: " + clientName);
        }

        void setPetName(String petName) {
            this.petName = petName;
            logger.info("Pet name has been set: " + petName);
        }

        void setPetSubClass(String petSubClass) {
            if (petSubClass.equals("Cat") || petSubClass.equals("Dog")) {
                this.petSubClass = petSubClass;
                logger.info("Pet subclass has been set: " + petSubClass);
            }
        }

        /*
        * Метод создает клиента и добавляет в клинику
         */
        void createNewClient() {
            Clinic clinic = Clinic.getClinicInstance();
            if (clinic.isExist(this.clientName)) {
                JFrame infoFrame = new JFrame();
                infoFrame.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(infoFrame, "Client with such name is exists");
            } else {
                PetFactory petFactory = new PetFactory();
                Pet pet = petFactory.getPet(this.petSubClass, this.clientName, this.petName);
                Client client = new Client(clientName, pet);
                clinic.addClient(client);
            }
        }

    }
}


