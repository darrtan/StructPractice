package createThread.volatileTest;

import sun.java2d.pipe.SpanIterator;

public class Test01 {
    public static void main(String[] args) {
        PrintString printString = new PrintString();
//        printString.printStringMethod();

//        开启子线程，让子线程执行printString的方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                printString.printStringMethod();
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("在main线程中修过打印标志");
        printString.setContinuePrint(false);


    }
}
class PrintString {
    private volatile boolean continuePrint = true;

    public void setContinuePrint(boolean continuePrint) {
        this.continuePrint = continuePrint;
    }

    public void printStringMethod() {
        System.out.println(Thread.currentThread().getName() + "------>开始");
        while (continuePrint) {
//                System.out.println("sub thread......");
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
        }
        System.out.println(Thread.currentThread().getName() + "------>结束");


    }
}