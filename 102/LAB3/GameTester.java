import java.util.Scanner;

public class GameTester {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.print("Please choose the difficulty level. Press 1 for easy, 2 for medium and 3 for hard: ");
        int difficultychoice = in.nextInt();
        Game aGame = new Game(difficultychoice);
        aGame.play();

    }
}
