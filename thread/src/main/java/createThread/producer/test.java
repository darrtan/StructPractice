package createThread.producer;

//测试一生产，以消费的情况
public class test {
    public static void main(String[] args) {
        ValuesEX valuesEX = new ValuesEX();

        ProducerThread P = new ProducerThread(valuesEX);
        ConsumerThread c = new ConsumerThread(valuesEX);
        P.start();
        c.start();

    }
}
