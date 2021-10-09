import model.Person;
import model.Player;
import model.Robot;
import model.Strategy;
import module.Controller;

public class PlayField {
    public static void main(String[] args) {
        Controller controller = new Controller(new Person("Pistike"), new Robot("Robot", Strategy.MATH));

        Player winner = controller.playGame();
        controller.printWinner(winner);


    }
}
