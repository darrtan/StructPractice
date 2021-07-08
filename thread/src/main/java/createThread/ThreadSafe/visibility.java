package createThread.ThreadSafe;

import createThread.Thread.MyThread2;

public class visibility {
    public static void main(String[] args) throws InterruptedException {
        myTask myTask = new myTask();
        new Thread(myTask).start();

        Thread.sleep(1000);
        myTask.cancel();
    }
}
class myTask implements Runnable{
    private boolean toCancel = false;

    @Override
    public void run() {
        while (!toCancel) {
            if (dpSomething()) {
            }
        }
        if (toCancel) {
            System.out.println("--------------任务取消");
        } else {
            System.out.println("---------------任务正常结束");
        }
    }

    private boolean dpSomething() {
        System.out.println("----------执行某个任务");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void cancel() {
        toCancel = true;
        System.out.println("----------收到 取消线程的消息");
    }
}