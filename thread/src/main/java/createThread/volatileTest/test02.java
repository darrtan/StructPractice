package createThread.volatileTest;

import sun.font.FontRunIterator;

public class test02 {
    public static void main(String[] args) {

        for (int i = 0; i <10; i++) {
            new test().start();
        }

    }
}

class  test extends Thread {
    private static int count;
    public synchronized static void addCount() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
        System.out.println(Thread.currentThread().getName() + " :" + count);
    }

    @Override
    public void run() {
        addCount();
    }
}