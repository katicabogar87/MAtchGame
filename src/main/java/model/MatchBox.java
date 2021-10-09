package model;

import lombok.Getter;

import java.util.List;

public class MatchBox {


   //private int startingNumOfMatches;
    @Getter
    private int currentNumOfMatches;
    @Getter
    private List<Integer> allowedPicks = List.of(1,2,3);
    private static final int minStart = 4;
    private static final int maxStart = 40;

    public MatchBox() {
        currentNumOfMatches = generateStartingNumOfMatches();

    }

    public void decrementCurrentNumOfMatches(int pick){
        currentNumOfMatches-=pick;
    }

    private int generateStartingNumOfMatches(){
        return (int)(Math.random() * (maxStart-minStart+1)) + minStart;
    }
}
