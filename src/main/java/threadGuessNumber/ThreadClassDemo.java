package threadGuessNumber;

import threadsDisplayMessage.DisplayMessage;

// Название файла: ThreadClassDemo.java
public class ThreadClassDemo {

    public static void main(String [] args) {
        Runnable hello = new DisplayMessage("Привет");
        Thread thread1 = new Thread(hello);
        thread1.setDaemon(true);
        thread1.setName("привет");
        System.out.println("Запуск потока привет...");
        thread1.start();

        Runnable bye = new DisplayMessage("Пока");
        Thread thread2 = new Thread(bye);
        thread2.setPriority(Thread.MIN_PRIORITY);
        thread2.setDaemon(true);
        System.out.println("Запуск потока пока...");
        thread2.start();

        System.out.println("Запуск потока3...");
        Thread thread3 = new GuessANumber(27);
        thread3.start();
        try {
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Поток прерван.");
        }
        System.out.println("Запуск потока4...");
        Thread thread4 = new GuessANumber(75);

        thread4.start();
        System.out.println("main() завершается...");
    }
}
