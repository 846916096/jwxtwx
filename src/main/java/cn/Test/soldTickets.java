package cn.Test;

/**
 * @author MiaoQ
 * @create 2018-03-20-20:16
 */
public class soldTickets implements Runnable {
    static int a = 100;
    static Object ob = new Object();


    public void run() {
        while (a > 0) {
            synchronized (ob)
            {
                if (a > 0) {
                    a--;
                    System.out.println(Thread.currentThread().getName()
                            + "正在卖票,还剩" + a + "张票");
                } else {
                    return;
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
