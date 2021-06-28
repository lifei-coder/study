package basic.thread;

/**
 * @author lifei1@songguo7.com
 * @date 2021/3/30 20:11
 */
public class DeadLock {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();


    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock1) {
                sleep(2000);
                System.out.println("线程1 等lock2");
                synchronized (lock2) {
                    System.out.println("线程1，完成 ");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock2) {
                sleep(2000);
                System.out.println("线程1 等lock2");
                synchronized (lock1) {
                    System.out.println("线程1，完成 ");
                }
            }
        }).start();
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
