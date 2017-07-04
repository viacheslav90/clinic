package ActionListeners.MainScreenActionListeners;

import Frames.AddClientFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

/**
 * Created by Slavka Dontsov on 04.07.2017.
 */
public class AddClientActionListener implements EventListener, ActionListener {

    public void actionPerformed(ActionEvent e){
        AddClientFrame addClientFrame = new AddClientFrame();
    }
}
