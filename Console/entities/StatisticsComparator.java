package entities;
import java.util.Comparator;

public class StatisticsComparator implements Comparator<SportsClub> {
    	@Override
    	public int compare(SportsClub o1, SportsClub o2) {
        	// DownCasting SportsClub objects to Football objects.
        	//Then assigning to Football reference variables.
        	FootballClub f1 = (FootballClub)o1;
        	FootballClub f2 = (FootballClub)o2;
        	if (f1.getPoints()>f2.getPoints()) {
            	//Checks whether sportsClub 1 is greater than sportsClub 2 by points.
            		return 1;
        	}else if (f1.getPoints()<f2.getPoints()){
            	//Checks whether sportsClub 1 is less than sportsClub 2 by points.
            		return -1;
        	}else if (f1.getPoints()==f2.getPoints()){
            	//Checks whether sportsClub 1 is equal to sportsClub 2 by points.
            		if (f1.getGoalDifference()>f2.getGoalDifference()){
                	//Checks for the goal difference between the two Clubs by goal difference.
                		return 1;
            		}else if (f1.getGoalDifference()<f2.getGoalDifference()){
                	//Checks for the goal difference between the two Clubs by goal difference.
                		return -1;
            		}else {
                		return 0;
            		}
        	}
        return 0;
    	}
}
