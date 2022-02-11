public class TestThread {

    public static void main(String args[]) {
        RunnableDemo R1 = new RunnableDemo( "Поток-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo( " Поток-2");
        R2.start();
    }
}