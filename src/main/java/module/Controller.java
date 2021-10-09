package module;

import model.MatchBox;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private MatchBox matchBox = new MatchBox();
    private List<Player> players = new ArrayList<>();

    public Controller(Player player1, Player player2) {
        players = List.of(player1, player2);
    }

    public Player playGame(){
        System.out.println("Let's start the game.");
        System.out.println("There are "+ matchBox.getCurrentNumOfMatches() + " matches on the table");
        Player winner = null;
       while (winner==null){
           for (Player player:players) {
               int pick = player.pickSomeMatches(matchBox);
               System.out.println(player + "'s pick: "+pick);
               matchBox.decrementCurrentNumOfMatches(pick);
               System.out.println("Remaining matches: "+matchBox.getCurrentNumOfMatches());
               if(matchBox.getCurrentNumOfMatches()==1){winner = player;}
               else
               if(matchBox.getCurrentNumOfMatches()==0){
                   for (Player currentPlayer:players) {
                       if(!currentPlayer.equals(player)){
                           winner = currentPlayer;
                       }
                   }
               }
           }
       }


        return winner;
    }

    public int pickStarter(){
        Player winner = null;
        int num =  (int)(Math.random() * (100)) + 1;

        return num%2;
    }

    public void printWinner(Player winner){
        System.out.println("Winner is: " + winner.toString());
    }
}
