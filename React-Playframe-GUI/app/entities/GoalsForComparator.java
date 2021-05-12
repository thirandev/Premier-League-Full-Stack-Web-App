package entities;
import java.util.Comparator;

public class GoalsForComparator implements Comparator<SportsClub> {
    	@Override
    	public int compare(SportsClub o1, SportsClub o2) {
        	// DownCasting SportsClub objects to Football objects.
        	//Then assigning to Football reference variables.
        	FootballClub f1 = (FootballClub)o1;
        	FootballClub f2 = (FootballClub)o2;
        	if (f1.getGoalsFor()>f2.getGoalsFor()) {
            	//Checks whether sportsClub 1 is greater than sportsClub 2 by goals scored.
            		return 1;
        	}else if (f1.getGoalsFor()<f2.getGoalsFor()){
            	//Checks whether sportsClub 1 is less than sportsClub 2 by goals scored.
            		return -1;
        	}else {
            		return 0;
        	}
    	}
}
