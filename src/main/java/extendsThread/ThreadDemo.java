package extendsThread;

class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    ThreadDemo( String name) {
        threadName = name;
        System.out.println("Создание " +  threadName );
    }

    public void run() {
        System.out.println("Выполнение " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Поток: " + threadName + ", " + i);
                // Пусть поток немного подождет.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Поток " + threadName + " прерывается.");
        }
        System.out.println("Поток " +  threadName + " завершается.");
    }

    public void start () {
        System.out.println("Запуск " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
