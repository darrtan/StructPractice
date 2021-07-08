package createThread.simpleTimer;

public class SimpleTimer {
    public static void main(String[] args) {
        int remaining = 60;  //从60s开始

        while (true) {
            System.out.println("remain : " + remaining);
            remaining--;
            if (remaining < 0) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
