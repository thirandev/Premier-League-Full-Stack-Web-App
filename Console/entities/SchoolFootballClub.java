package entities;
public class SchoolFootballClub extends FootballClub{
	//Instance Variables
	private String schoolName;
    	private String schoolRegion;
	
	//Constructor
    	public SchoolFootballClub(String clubName, String clubLocation, int matchesPlayed, int noOfWins, int noOfDraws,
                              int noOfDefeats, int goalsFor, int goalsAgainst,int goalDifference, int points,String schoolName,
                              String schoolRegion) {
        	super(clubName, clubLocation, matchesPlayed, noOfWins, noOfDraws, noOfDefeats, goalsFor, goalsAgainst,goalDifference,points);
        	this.schoolName = schoolName;
        	this.schoolRegion = schoolRegion;
    	}
	//Getter Methods
    	public String getSchoolName() {
        	return schoolName;
    	}
    	public String getSchoolRegion() {
        	return schoolRegion;
    	}
	//Setter Methods
    	public void setSchoolName(String schoolName) {
        	this.schoolName = schoolName;
    	}
    	public void setSchoolRegion(String schoolRegion) {
        	this.schoolRegion = schoolRegion;
    	}
	//Overrinding toString method
    	@Override
    	public String toString() {
        	return "SchoolFootballClub{" + super.toString() +", School Name='" + schoolName +
                	", School Region='" + schoolRegion +'}';
    	}
}
