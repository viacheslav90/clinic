package ActionListeners.MainScreenActionListeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 08.07.2017.
 */
public class WindowCloseListener extends WindowAdapter {

    // creating Logger instance
    private static final Logger logger = Logger.getLogger(WindowCloseListener.class.toString());

    /**
     * overriding windows closing default
     * @param e - event
     */
    @Override
    public void windowClosing(WindowEvent e) {
        if(e.getID() == WindowEvent.WINDOW_CLOSING){
            Thread.currentThread().interrupt();
            logger.info("Window was closed. Current thread was interrupt");
        }
    }
}
