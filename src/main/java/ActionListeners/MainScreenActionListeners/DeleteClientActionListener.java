package ActionListeners.MainScreenActionListeners;

import Frames.DeleteClientFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 04.07.2017.
 */
public class DeleteClientActionListener implements ActionListener {

    private static final Logger logger = Logger.getLogger(DeleteClientActionListener.class.toString());

    /**
     * create DeleteClientFrame
     * @param e - event
     */
    public void actionPerformed(ActionEvent e) {
        DeleteClientFrame deleteClientFrame = new DeleteClientFrame();
        logger.info("actionPrerformed method from DeleteClientActionListener was called");
    }
}
