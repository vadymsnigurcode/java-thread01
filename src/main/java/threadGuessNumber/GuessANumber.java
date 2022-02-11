package threadGuessNumber;

// Название файла: GuessANumber.java
// Создаем поток для расширения Thread

public class GuessANumber extends Thread {
    private int number;
    public GuessANumber(int number) {
        this.number = number;
    }

    public void run() {
        int counter = 0;
        int guess = 0;
        do {
            guess = (int) (Math.random() * 100 + 1);
            System.out.println(this.getName() + " угадываний " + guess);
            counter++;
        } while(guess != number);
        System.out.println("** Верно!" + this.getName() + "за" + counter + "угадываний.**");
    }
}
