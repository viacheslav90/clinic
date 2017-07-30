package ActionListeners.MainScreenActionListeners;

import Frames.SearchClientFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

/**
 * Created by Slavka Dontsov on 04.07.2017.
 */
public class SearchByNameActionListener implements ActionListener{

    //create Logger instance
    private static final Logger logger = Logger.getLogger(SearchByNameActionListener.class.toString());

    /**
     * create SearchByNameFrame
     * @param e - event
     */
    public void actionPerformed(ActionEvent e) {

        SearchClientFrame searchClientFrame = new SearchClientFrame();
        logger.info("aactionPrerformed method from SearchByNameActionListener was called");
    }
}
