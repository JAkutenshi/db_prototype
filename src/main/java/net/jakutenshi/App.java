package net.jakutenshi;

import net.jakutenshi.controller.mainframe.MainFrameController;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        new Thread(MainFrameController::new).start();
    }
}
