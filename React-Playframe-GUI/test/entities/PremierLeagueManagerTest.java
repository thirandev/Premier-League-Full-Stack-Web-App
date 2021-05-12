package entities;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PremierLeagueManagerTest {

    LeagueManager manager = PremierLeagueManager.getInstance();
    List<SportsClub> testClubList = manager.sortPremierLeagueClubs();
    List<Match> testMatchList = manager.sortedMatchList();
    SportsClub testClub1 = new FootballClub("Liverpool","Anfield",10,10,0,0,20,10,10,50);
    SportsClub testClub2 = new FootballClub("Chelsea","Stamford Bridge",10,5,1,4,10,5,5,30);

    @Test
    public void addFootballClubTest() {
        boolean flag = false;
        manager.addFootballClub(testClub1);
        manager.addFootballClub(testClub2);
        for (SportsClub club: testClubList){
            if (club.equals(testClub1)){
                flag = true;
            }
        }
        assertTrue(flag);
    }
    @Test
    public void deleteFootballClubTest(){
        addFootballClubTest();
        int before = testClubList.size();
        manager.deleteFootballClub();
        int after = testClubList.size();
        assertEquals((before-1),after);

    }
    @Test
    public void displayClubStatisticsTest(){
        addFootballClubTest();
        manager.displayClubStatistics(testClub1.getClubName());
    }
    @Test
    public void displayLeagueTableTest(){
        addFootballClubTest();
        manager.displayLeagueTable();
    }
    @Test
    public void addPlayedMatchTest(){
        addFootballClubTest();
        boolean flag = false;
        String[] clubNames ={testClub1.getClubName(),testClub2.getClubName()};
        int[] clubScores = {10, 12};
        manager.addPlayedMatch(new Date(20,1,2020),clubNames,clubScores);
        for (Match match: testMatchList){
            boolean compareTeam1 = match.getTeam1().equals(testClub1);
            boolean compareTeam2 = match.getTeam2().equals(testClub2);
            if (compareTeam1 && compareTeam2){
                flag = true;
            }
        }
        assertTrue(flag);
    }
    @Test
    public void generateMatchTest(){
        addFootballClubTest();
        boolean flag = false;
        Match testMatch = manager.generateMatch();
        for (Match match: testMatchList){
            if (match.equals(testMatch)){
                flag = true;
            }
        }
        assertTrue(flag);
    }
    @Test
    public void saveClubListTest(){
        addFootballClubTest();
        manager.saveToFile("TestFile.txt");
    }
    @Test
    public void loadClubListTest(){
        boolean flag = false;
        manager.loadFile("TestFile.txt");
        int clubCompare = 0;
        for (SportsClub club:testClubList){
            if (club.equals(testClub1)){
                clubCompare++;
            }else if(club.equals(testClub2)){
                clubCompare++;
            }
        }
        assertEquals(2,clubCompare);
    }

    @Test
    public void saveMatchListTest(){
        addPlayedMatchTest();
        generateMatchTest();
        manager.saveMatches("TestFile2.txt");
    }
    @Test
    public void loadMatchListTest(){
        int before = testMatchList.size();
        manager.loadMatches("TestFile2.txt");
        int after = testMatchList.size();
        assertEquals((before+2),after);
    }
}