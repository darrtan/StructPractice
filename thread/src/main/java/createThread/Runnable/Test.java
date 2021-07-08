package createThread.Runnable;

public class Test {
    public static void main(String[] args) {
        ThreadTest runnable = new ThreadTest();

        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {

                    try {
                        System.out.println("----------------runnable2 : " + i);
                        int time = (int) (Math.random() * 1000);
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        thread2.start();
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
