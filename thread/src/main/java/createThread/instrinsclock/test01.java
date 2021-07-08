package createThread.instrinsclock;

import createThread.Thread.Test;

public class test01 {
    public static void main(String[] args) {
        test01 test01 = new test01();


        new Thread(new Runnable() {
            @Override
            public void run() {
                test01.sum();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test01.sum();
            }
        }).start();
    }

    public void sum() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
