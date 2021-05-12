package entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class FootballClubTest {
    FootballClub testClub = new FootballClub("TestClub","TestLocation",0,0,0,0,0,0,0,0);
    @Test
    public void TestClub(){
        //The Test Checks if the setter and getters functions properly.
        //To pass the test the passTest variable must be 10,which is equal to the number of instance variables in the FootballClub class.
        int passTest = 0;
        String [] testStrings = {"Liverpool","Anfield"};
        int [] testInteger = {10,5,1,4,20,10,10,50};
        testClub.setClubName(testStrings[0]);
        testClub.setClubLocation(testStrings[1]);
        testClub.setMatchesPlayed(testInteger[0]);
        testClub.setNoOfWins(testInteger[1]);
        testClub.setNoOfDraws(testInteger[2]);
        testClub.setNoOfDefeats(testInteger[3]);
        testClub.setGoalsFor(testInteger[4]);
        testClub.setGoalsAgainst(testInteger[5]);
        testClub.setGoalDifference(testInteger[6]);
        testClub.setPoints(testInteger[7]);

        if (testStrings[0].equals(testClub.getClubName())){
            passTest++;
        }
        if (testStrings[1].equals(testClub.getClubLocation())){
            passTest++;
        }
        if (testInteger[0] == testClub.getMatchesPlayed()){
            passTest++;
        }
        if (testInteger[1] == testClub.getNoOfWins()){
            passTest++;
        }
        if (testInteger[2] == testClub.getNoOfDraws()){
            passTest++;
        }
        if (testInteger[3] == testClub.getNoOfDefeats()){
            passTest++;
        }
        if (testInteger[4] == testClub.getGoalsFor()){
            passTest++;
        }
        if (testInteger[5] == testClub.getGoalsAgainst()){
            passTest++;
        }
        if (testInteger[6] == testClub.getGoalDifference()){
            passTest++;
        }
        if (testInteger[7] == testClub.getPoints()){
            passTest++;
        }
        assertEquals(10,passTest);
    }
}