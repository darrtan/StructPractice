package createThread.ThreadLocal;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Test2 {


    static class myLock extends Thread{
        private static ReentrantLock lock = new ReentrantLock();
        @Override
        public void run() {
            try {
                if (lock.tryLock(3, TimeUnit.SECONDS)) {
                    System.out.println(Thread.currentThread().getName() + "--获得锁对象");
                    Thread.sleep(3000);
                } else {
                    System.out.println(Thread.currentThread().getName() + " --没有获得锁");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }

            }
        }
    }


    public static void main(String[] args) {
        myLock myLock1 = new myLock();
        myLock myLock = new myLock();

        myLock.start();
        myLock1.start();


    }
}
