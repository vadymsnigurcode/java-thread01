package threadMutalBlockingSolution;

public class Main {
    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();

    public static void main(String args[]) {
        ThreadDemo1 T1 = new ThreadDemo1();
        ThreadDemo2 T2 = new ThreadDemo2();
        T1.start();
        T2.start();
    }

    private static class ThreadDemo1 extends Thread {
        public void run() {
            synchronized (Lock1) {
                System.out.println("Поток 1: Удерживает блокировку 1...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
                System.out.println("Поток 2: Ожидает блокировку 2...");

                synchronized (Lock2) {
                    System.out.println("Поток 1: Удерживает блокировку 1 и 2...");
                }
            }
        }
    }
    private static class ThreadDemo2 extends Thread {
        public void run() {
            synchronized (Lock1) {
                System.out.println("Поток 2: Удерживает блокировку 1...");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
                System.out.println("Поток 2: Ожидает блокировку 2...");

                synchronized (Lock2) {
                    System.out.println("Поток 2: Удерживает блокировку 1 и 2...");
                }
            }
        }
    }
}
