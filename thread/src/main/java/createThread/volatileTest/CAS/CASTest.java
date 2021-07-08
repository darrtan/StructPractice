package createThread.volatileTest.CAS;

public class CASTest {
    public static void main(String[] args) {
        CASCounter casCounter = new CASCounter();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(casCounter.incrementAndGet());
                }
            }).start();
        }

    }
}
class CASCounter {
//    使用volatile修饰value值,使线程可见
    volatile private long value;

    public long getValue() {
        return value;
    }

//    定义CAS方法
    private boolean cas(long expectedValue,long newValue) {
//        如果当前value的值与期望的expectedValue的值一样，就把当前Value字段替换为newValue字段
        synchronized (this) {
            if (value == expectedValue) {
                value = newValue;
                return true;
            } else {
                return false;
            }
        }
    }

//    定义自增方法
    public long incrementAndGet() {
        long oldValue,newValue;
        do {
            oldValue = value;
            newValue = oldValue +1;
        } while (!cas(oldValue,newValue));
        return newValue;
    }
}