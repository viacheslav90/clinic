package Threads;

import Frames.AddClientFrame;

/**
 * Created by Slavka Dontsov on 08.07.2017.
 */
public class AddClientThread extends Thread {

    public void run(){
        AddClientFrame addClientFrame = new AddClientFrame();
    }
}
