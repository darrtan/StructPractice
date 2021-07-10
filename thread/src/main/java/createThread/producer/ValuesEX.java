package createThread.producer;

public class ValuesEX {
    private String value = "" ;
//    定义方法修改value字段的值
    public void setValue() {
        synchronized (this) {
            while (!value.equalsIgnoreCase("")) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String value = System.currentTimeMillis() + " - " + System.nanoTime();
            System.out.println("set设置的值为" + value);
            this.value = value;
            this.notifyAll();
        }
    }

//    定义方法读取字段量
    public void getValue() {
        synchronized (this) {
            while (value.equalsIgnoreCase("")) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

//            不是空字符串
            System.out.println("get的值为" + this.value);
            this.value = "";
//            在多生产者多消费者的环境中，notify（）不能保证是生产者唤醒消费者
//            生产者可能会出现假死的情况
            this.notifyAll();
        }
    }
}
