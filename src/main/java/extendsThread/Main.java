package extendsThread;

public class Main {

    public static void main(String args[]) {
        ThreadDemo T1 = new ThreadDemo( "Поток-1");
        T1.start();

        ThreadDemo T2 = new ThreadDemo( "Поток-2");
        T2.start();
    }
}
