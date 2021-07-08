package createThread.ThreadDaemon;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {

        ThreadDaemon threadDaemon = new ThreadDaemon();
        Thread thread = new Thread(threadDaemon);
        thread.setDaemon(true);
        thread.start();
        System.out.println("isDaemon = " + thread.isDaemon());

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
