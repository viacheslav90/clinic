package ActionListeners.MainScreenActionListeners;

import Frames.AddClientFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 04.07.2017.
 */
public class AddClientActionListener implements EventListener, ActionListener {

    private static final Logger logger = Logger.getLogger(AddClientActionListener.class.toString());

    public void actionPerformed(ActionEvent e){
        logger.info("aactionPrerformed method from AddClientActionListener was called");
        AddClientFrame addClientFrame = new AddClientFrame();
    }
}
