package threadDriving;

class RunnableDemo implements Runnable {
    public Thread t;
    private String threadName;
    boolean suspended = false;

    RunnableDemo(String name) {
        threadName = name;
        System.out.println("Создание " + threadName);
        //System.out.println("this=" + this.hashCode());
    }

    public void run() {
        System.out.println("Выполнение " + threadName);
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println("Поток: " + threadName + ", " + i);
                // Пусть поток немного подождет.
                Thread.sleep(300);
                System.out.println("before synch this="+this.hashCode());
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Поток " + threadName + " прерван.");
        }
        System.out.println("Поток " + threadName + " завершается.");
    }

    public void start() {
        System.out.println("Запуск " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    void suspend() {
        suspended = true;
    }

    synchronized void resume() {
        suspended = false;
        notify();
    }
}

public class Main {

    public static void main(String args[]) {

        RunnableDemo R1 = new RunnableDemo("Поток-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo(" Поток-2");
        R2.start();

        try {
            Thread.sleep(1000);
            R1.suspend();
            System.out.println("Приостановка первого потока");
            Thread.sleep(1000);
            R1.resume();
            System.out.println("Возобновление первого потока");

            R2.suspend();
            System.out.println("Приостановка второго потока");
            Thread.sleep(1000);
            R2.resume();
            System.out.println("Возобновление второго потока");
        } catch (InterruptedException e) {
            System.out.println("Основной поток прерван");
        }
        try {
            System.out.println("Ожидание завершения потоков.");
            R1.t.join();
            R2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Основной поток прерван");
        }
        System.out.println("Основной поток завершается.");
    }
}
