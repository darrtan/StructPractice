package createThread.ThreadDaemon;

public class ThreadDaemon implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println("___________ThreadDaemon");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
