package entities;
import java.io.Serializable;
import java.util.Objects;

public class Match implements Serializable {
	//Instance Variables
	private SportsClub team1;
    	private SportsClub team2;
    	private Date date;
   	private int score1;
    	private int score2;
	//Constructor
    	public Match(Date date, SportsClub team1, SportsClub team2, int score1, int score2){
        	this.date = date;
        	this.team1 = team1;
        	this.team2 = team2;
        	this.score1 = score1;
        	this.score2 = score2;
    	}
	//Getters and setters
    	public SportsClub getTeam1() {
        	return team1;
    	}
    	public void setTeam1(SportsClub team1) {
        	this.team1 = team1;
    	}

    	public SportsClub getTeam2() {
        	return team2;
    	}

    	public void setTeam2(SportsClub team2) {
        	this.team2 = team2;
    	}

    	public Date getDate() {
        	return date;
    	}
    	public void setDate(Date date) {
        	this.date = date;
    	}
    	public int getScore1() {
        	return score1;
    	}
    	public void setScore1(int score1) {
        	this.score1 = score1;
    	}
    	public int getScore2() {
        	return score2;
    	}
    	public void setScore2(int score2) {
        	this.score2 = score2;
    	}
    	@Override
    	public String toString() {
        	return "Match{" +
                	"team1=" + team1.getClubName() +
                	", team2=" + team2.getClubName() +
                	", date=" + date +
                	", score1=" + score1 +
                	", score2=" + score2 +
                	'}';
    	}
}
