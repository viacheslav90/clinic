package ActionListeners.MainScreenActionListeners;

import Threads.AddClientThread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 04.07.2017.
 */
public class AddClientActionListener implements EventListener, ActionListener {

    private static final Logger logger = Logger.getLogger(AddClientActionListener.class.toString());

    /**
     * create AcdClientFrame in a new thread
     * @param e - event
     */
    public void actionPerformed(ActionEvent e){
        logger.info("actionPrerformed method from AddClientActionListener was called");
        AddClientThread addClientThread = new AddClientThread();
        addClientThread.run();
    }
}
