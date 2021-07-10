package createThread.producer;
//多生产，多消费的情况
public class Test2 {
    public static void main(String[] args) {
        ValuesEX valuesEX = new ValuesEX();

        ProducerThread P = new ProducerThread(valuesEX);
        ConsumerThread c = new ConsumerThread(valuesEX);
        ProducerThread P1 = new ProducerThread(valuesEX);
        ConsumerThread c1 = new ConsumerThread(valuesEX);
        ProducerThread P2 = new ProducerThread(valuesEX);
        ConsumerThread c2 = new ConsumerThread(valuesEX);
        P.start();
        c.start();
        P1.start();
        c1.start();
        c2.start();
        P2.start();
    }
}
