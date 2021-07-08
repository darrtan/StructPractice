package createThread.Thread;

public class Test {
    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        myThread.start();
//        System.out.println("--------------------------main");
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("--------main: ： " + i);
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
