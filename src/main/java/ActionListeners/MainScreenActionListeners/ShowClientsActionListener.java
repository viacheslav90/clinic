package ActionListeners.MainScreenActionListeners;

import Frames.ShowClientsFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 04.07.2017.
 */
public class ShowClientsActionListener implements ActionListener{

    public static final Logger logger = Logger.getLogger(ShowClientsActionListener.class.toString());

    public void actionPerformed(ActionEvent e) {
        ShowClientsFrame showClientsFrame = new ShowClientsFrame();
        logger.info("aactionPrerformed method from ShowClientsActionListener was called");


    }
}
