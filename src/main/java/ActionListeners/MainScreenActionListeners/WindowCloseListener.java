package ActionListeners.MainScreenActionListeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 08.07.2017.
 */

    /*
    * Класс для обработки закрытия окна
     */
public class WindowCloseListener extends WindowAdapter {

    private static final Logger logger = Logger.getLogger(WindowCloseListener.class.toString());

    /*
    * Метод прерывает поток при закрытии окна
     */
    @Override
    public void windowClosing(WindowEvent e) {
        if(e.getID() == WindowEvent.WINDOW_CLOSING){
            Thread.currentThread().interrupt();
            logger.info("Window was closed. Current thread was interrupt");
        }
    }
}
