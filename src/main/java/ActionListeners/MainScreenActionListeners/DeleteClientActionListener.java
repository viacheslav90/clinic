package ActionListeners.MainScreenActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 04.07.2017.
 */
public class DeleteClientActionListener implements ActionListener {

    private static final Logger logger = Logger.getLogger(DeleteClientActionListener.class.toString());

    public void actionPerformed(ActionEvent e) {
        logger.info("aactionPrerformed method from DeleteClientActionListener was called");

    }
}
