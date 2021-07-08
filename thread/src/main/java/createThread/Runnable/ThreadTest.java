package createThread.Runnable;

public class ThreadTest implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("--------runnable: ： " + i);
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
