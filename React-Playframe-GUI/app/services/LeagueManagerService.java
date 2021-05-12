package services;

import entities.LeagueManager;
import entities.Match;
import entities.PremierLeagueManager;
import entities.SportsClub;

import java.util.List;

public class LeagueManagerService {

    static LeagueManager manager = PremierLeagueManager.getInstance();
    private static LeagueManagerService instance;

    public static LeagueManagerService getInstance() {
        if (instance == null) {
            instance = new LeagueManagerService();
        }
        return instance;
    }

    public List<SportsClub> getAllSportsCLub() {
        manager.loadFile("../PremierLeagueCLubData.txt");
        return manager.sortPremierLeagueClubs();
    }
    public  List<SportsClub> getAllSportsCLubByGoals() {
        manager.loadFile("../PremierLeagueCLubData.txt");
        return manager.sortPremierLeagueClubsByGoals();
    }
    public  List<SportsClub> getAllSportsCLubByWins() {
        manager.loadFile("../PremierLeagueCLubData.txt");
        return manager.sortPremierLeagueClubsByWins();
    }
    public  List<Match> getAllMatches() {
        manager.loadMatches("../MatchData.txt");
        return manager.sortedMatchList();
    }
    public Match generateMatch(){
        Match newMatch = manager.generateMatch();
        manager.saveToFile("../PremierLeagueCLubData.txt");
        manager.saveMatches("../MatchData.txt");
        return newMatch;
    }

}
