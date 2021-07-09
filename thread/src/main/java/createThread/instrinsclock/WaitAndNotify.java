package createThread.instrinsclock;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class WaitAndNotify {
    public static void main(String[] args) {
        String lock = "1";


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("-----线程1开始：" + Thread.currentThread().getState());
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("-----------------线程1结束" + Thread.currentThread().getState());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("----------------线程2开始 "   + Thread.currentThread().getState() );
                    lock.notify();
                    System.out.println("------------------线程2结束 ： " + Thread.currentThread().getState());
                }


            }
        }).start();
    }
}
