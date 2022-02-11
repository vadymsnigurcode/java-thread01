package threadSuspend;

public class Main {

    public static void main(String[] args) {
        ThreadDemo threadDemo1 = new ThreadDemo("t1");
        ThreadDemo threadDemo2 = new ThreadDemo("t2", true);
        threadDemo1.start();
        threadDemo2.start();
    }
}

class ThreadDemo extends Thread {
    private Thread t;
    String threadName;
    boolean resume;

    public ThreadDemo(String name) {
        //super(name);
        threadName = name;
    }

    public ThreadDemo(String name, boolean b) {
        //super(name);
        threadName = name;
        resume = b;
    }

    public void start() {
        System.out.println("Запуск " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            System.out.println("t.getState()" + t.getState());
            System.out.println("t.isAlive()" + t.isAlive());
            t.start();
            System.out.println("t.getState()" + t.getState());
            System.out.println("t.isAlive()" + t.isAlive());
        }
    }

    public void run() {
        int k = 1;
        while (true) {
            System.out.print("[" + threadName + "]");
            pause(500);
            if (k == 5) {
                try {
                    System.out.println();
                    System.out.println("waiting 5 sec for thread-" + threadName + "!");
                    synchronized (this) {
                        wait(5000);
                    }
                    System.out.println("continue execution thread-" + threadName);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (k == 10) {
                System.out.println();
                break;
            }
            k++;
        }
        System.out.println("t.getState()" + t.getState());
        System.out.println("t.isAlive()" + t.isAlive());
    }

    private void pause(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
