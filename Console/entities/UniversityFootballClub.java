package entities;
public class UniversityFootballClub extends FootballClub{
	//Instance Variables
	private String uniName;
    	private String uniDivision;

	//Constructor
    	public UniversityFootballClub(String clubName, String clubLocation, int matchesPlayed, int noOfWins,
                                  int noOfDraws, int noOfDefeats, int goalsFor, int goalsAgainst,int goalDifference, int points,
                                  String uniName,String uniDivision) {
        	super(clubName, clubLocation,matchesPlayed, noOfWins, noOfDraws, noOfDefeats, goalsFor, goalsAgainst,goalDifference, points);
        	this.uniName = uniName;
        	this.uniDivision = uniDivision;
    	}
	//Getter Methods
    	public String getUniName() {
        	return uniName;
    	}
    	public String getUniDivision() {
        	return uniDivision;
    	}
	//Setter Methods	
    	public void setUniName(String uniName) {
        	this.uniName = uniName;
    	}
    	public void setUniDivision(String uniDivision) {
        	this.uniDivision = uniDivision;
    	}
	//Overrinding toString method
    	@Override
    	public String toString() {
        	return " UniversityFootballClub {" + super.toString() +
                	", University Name='" + uniName +", University Division='" + uniDivision +'}';
    	}
}
