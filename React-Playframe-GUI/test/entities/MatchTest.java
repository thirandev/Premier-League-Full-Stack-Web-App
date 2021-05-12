package entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatchTest {
    Match testMatch = new Match(new Date(1,1,2000),null,null,0,0);
    @Test
    public void TestMatch(){
        //The Test Checks if the setter and getters functions properly.
        //To pass the test the passTest variable must be 5,which is equal to the number of
        // instance variables in the Match class.
        int passTest = 0;
        SportsClub testClub1 = new FootballClub("Liverpool","Anfield",10,10,0,0,20,10,10,50);
        SportsClub testClub2 = new FootballClub("Chelsea","Stamford Bridge",10,5,1,4,10,5,5,30);
        Date testDate = new Date(01,01,2021);
        int [] testScore = {10,5};
        testMatch.setDate(testDate);
        testMatch.setTeam1(testClub1);
        testMatch.setTeam2(testClub2);
        testMatch.setScore1(testScore[0]);
        testMatch.setScore2(testScore[1]);
        if (testMatch.getDate().equals(testDate)){
            passTest++;
        }
        if (testMatch.getTeam1().equals(testClub1)){
            passTest++;
        }
        if (testMatch.getTeam2().equals(testClub2)){
            passTest++;
        }
        if (testScore[0] == testMatch.getScore1()){
            passTest++;
        }
        if (testScore[1]== testMatch.getScore2()){
            passTest++;
        }
        assertEquals(5,passTest);
    }
}