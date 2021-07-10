package createThread.producer;

public class ConsumerThread extends Thread{
//    消费者使用数据，就是使用ValueOP类的字段值
    private ValuesEX obj;
    public ConsumerThread(ValuesEX obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        while (true) {
            obj.getValue();
        }
    }
}
