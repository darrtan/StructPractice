package createThread.ThreadLocal;

public class Test {
   static ThreadLocal threadLocal = new ThreadLocal();

   static class Subthread extends Thread {
       @Override
       public void run() {
           for (int i = 0; i < 20; i++) {
               threadLocal.set(Thread.currentThread().getName() + "-" + i);
               System.out.println(Thread.currentThread().getName() + "value " + threadLocal.get());
           }
       }
   }

    public static void main(String[] args) {
        Subthread subthread = new Subthread();
        Subthread subthread1 = new Subthread();

        subthread.start();
        subthread1.start();
    }
}
