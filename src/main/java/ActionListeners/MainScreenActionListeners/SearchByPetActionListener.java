package ActionListeners.MainScreenActionListeners;

import Frames.SearchClientByPetFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 04.07.2017.
 */
public class SearchByPetActionListener implements ActionListener {

    private static final Logger logger = Logger.getLogger(SearchByPetActionListener.class.toString());

    public void actionPerformed(ActionEvent e) {

        SearchClientByPetFrame searchClientByPetFrame = new SearchClientByPetFrame();
        logger.info("aactionPrerformed method from SearchByPetActionListener was called");

    }
}
