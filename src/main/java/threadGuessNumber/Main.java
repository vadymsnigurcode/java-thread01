package threadGuessNumber;

public class Main {
    public static void main(String[] args) {
        GuessANumber guessANumber = new GuessANumber(5);
        guessANumber.start();
    }
}
