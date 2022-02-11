package threadsDisplayMessage;

public class Main {
    public static void main(String[] args) {
        DisplayMessage displayMessage = new DisplayMessage("thread message");
        displayMessage.run();
    }
}
