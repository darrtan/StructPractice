package createThread.condition;

import javax.management.relation.RelationNotFoundException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
//    定义锁
    static Lock lock = new ReentrantLock();
//获得Condition对象
    static Condition condition = lock.newCondition();

    static class SubThread extends Thread{
        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println("method lock");
                condition.await();
                System.out.println("method await");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("method unlock");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SubThread t = new SubThread();
        t.start();
        //子线程启动后，会转入子线程的等待

        Thread.sleep(3000);
        try {
            lock.lock();
            condition.signal();
        } finally {
            lock.unlock();
        }


    }
}
