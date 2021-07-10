package createThread.productorStack;

public class Test {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        ProducerThread producerThread = new ProducerThread(myStack);
        ConsumerThread consumerThread = new ConsumerThread(myStack);
        producerThread.start();
        consumerThread.start();
    }
}
