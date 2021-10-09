package model;

import lombok.AllArgsConstructor;
import lombok.Getter;





@AllArgsConstructor
public class Robot implements Player {

    @Getter
    private String name;
    @Getter
    private Strategy strategy;




    public int pickSomeMatches(MatchBox matchBox) {

        int maxPick = matchBox.getAllowedPicks().get(matchBox.getAllowedPicks().size()-1);
        int current = matchBox.getCurrentNumOfMatches();
        switch (strategy) {
            case RANDOM -> {
                int top = Math.min(matchBox.getCurrentNumOfMatches(),maxPick);
                return  (int)(Math.random() * (top-1+1)) + 1;
            }
            case ONE_BY_ONE -> {
                return 1;
            }
            case MATH -> {
                if(current>maxPick){
                    if((current%(maxPick+1)==1) || (current%(maxPick+1)==2)){ return 1;}
                    if(current%(maxPick+1)==3){return 2;}
                    if(current%(maxPick+1)==0){return 3;}
                }
                else {
                    if (current == 3){return 2;}
                    if (current == 2){return 1;}
                }

            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
