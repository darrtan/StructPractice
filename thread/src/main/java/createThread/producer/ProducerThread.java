package createThread.producer;

public class ProducerThread extends Thread{

    private ValuesEX obj;
    public ProducerThread(ValuesEX obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        while (true) {
            obj.setValue();
        }
    }
}
