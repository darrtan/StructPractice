package createThread.ThreadSafe;

import createThread.ThreadDaemon.ThreadDaemon;

import java.util.concurrent.atomic.AtomicInteger;

public class Test0 {
    public static void main(String[] args) {
        safe safe = new safe();

        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        System.out.println(safe.getNum() + " <------" + Thread.currentThread().getName());
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                }
            }).start();
        }
    }
}
class safe{
    AtomicInteger num = new AtomicInteger();

    public int getNum() {
        return num.getAndIncrement();
    }
}