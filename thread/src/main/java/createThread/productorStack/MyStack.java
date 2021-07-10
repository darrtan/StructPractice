package createThread.productorStack;

import java.util.ArrayList;
import java.util.List;
 //模拟栈
public class MyStack {
    private List list = new ArrayList();
    private static final int MAX = 1;  //定义最大容量

//    定义方法模拟入栈

    public synchronized void push() {
        if (list.size()>=MAX) {

            try {
                System.out.println(Thread.currentThread().getName() + "-----------begin....wait");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String data = "data---" + Math.random();
            System.out.println(Thread.currentThread().getName() + "添加了数据" + data);
            list.add(data);
            this.notify();
        }
    }
//定义一个方法，模拟出栈
    public synchronized void pop() {
//        如果没有数据就等待
        if (list.size() == 0) {
            try {
                System.out.println(Thread.currentThread().getName() + "--------------begin wait");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "出栈数据" + list.remove(0));
        this.notify();
    }
}
