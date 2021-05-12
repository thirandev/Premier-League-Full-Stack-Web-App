package entities;
import java.util.List;

public interface LeagueManager {

    	void addFootballClub(SportsClub sportsClub);
    	void deleteFootballClub();
    	void displayClubStatistics(String clubName);
    	void displayLeagueTable();
    	void addPlayedMatch(Date date, String[] clubs, int[] scores);
    	Match generateMatch();
    	List<Match> sortedMatchList();
    	List<SportsClub> sortPremierLeagueClubs();
    	List<SportsClub> sortPremierLeagueClubsByGoals();
    	List<SportsClub> sortPremierLeagueClubsByWins();
    	void saveToFile(String fileName);
    	void saveMatches(String fileName);
    	void loadFile(String fileName);
    	void loadMatches(String fileName);

}
