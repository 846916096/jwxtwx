package cn.Test;

/**
 * @author MiaoQ
 * @create 2018-03-20-20:27
 */
public class TicketMain {
    public static void main(String[] args) {
        soldTickets runTicekt = new soldTickets();
        Thread th1 = new Thread(runTicekt, "窗口1");//每个线程等其他线程释放该锁后，才能执行
                Thread th2 = new Thread(runTicekt, "窗口2");
                Thread th3 = new Thread(runTicekt, "窗口3");
                Thread th4 = new Thread(runTicekt, "窗口4");
                th1.start();
                th2.start();
                th3.start();
                th4.start();
    }
}
