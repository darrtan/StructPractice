package createThread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


//多个Condition实现通知部分线程
public class Test1 {
    static class Service{
        private ReentrantLock lock = new ReentrantLock();
//        定义两个condition对象
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();

//        定义方法，使用conditionA等待
        public void waitMethodA() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "beginWait :  " + System.currentTimeMillis());
                conditionA.await();
                System.out.println(Thread.currentThread().getName() + "endWait :  " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }


        //        定义方法，使用conditionA等待
        public void waitMethodB() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "beginWait :  " + System.currentTimeMillis());
                conditionB.await();
                System.out.println(Thread.currentThread().getName() + "endWait :  " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

//        定义方法唤醒conditionA上的等待
        public void signalA() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " signal A time = " + System.currentTimeMillis());
                conditionA.signal();
                System.out.println(Thread.currentThread().getName() + " signal A time = " + System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        //        定义方法唤醒conditionB上的等待
        public void signalB() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " signal A time = " + System.currentTimeMillis());
                conditionB.signal();
                System.out.println(Thread.currentThread().getName() + " signal A time = " + System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.waitMethodA();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                service.waitMethodB();
            }
        }).start();

        Thread.sleep(3000);
//        唤醒conditionA对象上的等待,conditionB上的等待依然继续等待
        service.signalA();
    }
}
