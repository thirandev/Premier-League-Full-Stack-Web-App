package entities;
import java.util.Comparator;

public class WinsComparator implements Comparator<SportsClub> {
    	@Override
    	public int compare(SportsClub o1, SportsClub o2) {
        	// DownCasting SportsClub objects to Football objects.
        	//Then assigning to Football reference variables.
       		FootballClub f1 = (FootballClub)o1;
        	FootballClub f2 = (FootballClub)o2;
        	if (f1.getNoOfWins()>f2.getNoOfWins()) {
            	//Checks whether sportsClub 1 is greater than sportsClub 2.
            		return 1;
        	}else if (f1.getNoOfWins()<f2.getNoOfWins()){
            	//Checks whether sportsClub 1 is less than sportsClub 2.
            		return -1;
        	}else {
           		return 0;
        	}
    	}
}
