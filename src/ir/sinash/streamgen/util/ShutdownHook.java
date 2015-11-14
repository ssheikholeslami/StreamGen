package ir.sinash.streamgen.util;

/**
 * Created by sinash on 11/14/15.
 */
public class ShutdownHook extends Thread{


    @Override
    public void run() {

        System.out.println("Shutting Down...");
        System.out.println("useful info blah blah blah");
    }
}
