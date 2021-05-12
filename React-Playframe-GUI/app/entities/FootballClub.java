package entities;
public class FootballClub extends SportsClub{
	//Instance Variables
	private int matchesPlayed;
    	private int noOfWins;
    	private int noOfDraws;
    	private int noOfDefeats;
    	private int goalsFor;
    	private int goalsAgainst;
    	private int points;
    	private int goalDifference;

	//Constructor
    	public FootballClub(String clubName, String clubLocation,int matchesPlayed,int noOfWins,int noOfDraws,
                        	int noOfDefeats,int goalsFor,int goalsAgainst,int goalDifference,int points){
        	super(clubName,clubLocation);
        	this.matchesPlayed = matchesPlayed;
        	this.noOfWins = noOfWins;
        	this.noOfDraws = noOfDraws;
        	this.noOfDefeats = noOfDefeats;
        	this.goalsFor = goalsFor;
        	this.goalsAgainst = goalsAgainst;
        	this.points = points;
        	this.goalDifference = goalDifference;
    	}
	//Getter Methods
    	public int getMatchesPlayed() {
        	return matchesPlayed;
    	}
    	public int getNoOfWins() {
        	return noOfWins;
    	}
    	public int getNoOfDraws() {
        	return noOfDraws;
    	}
    	public int getNoOfDefeats() {
        	return noOfDefeats;
    	}
    	public int getGoalsFor() {
        	return goalsFor;
    	}
    	public int getGoalsAgainst() {
        	return goalsAgainst;
    	}
    	public int getGoalDifference() {
        	return goalDifference;
    	}
    	public int getPoints() {
        	return points;
    	}
	//Setter Methods
    	public void setMatchesPlayed(int matchesPlayed) {
        	this.matchesPlayed = matchesPlayed;
    	}
    	public void setNoOfWins(int noOfWins) {
        	this.noOfWins = noOfWins;
    	}
    	public void setNoOfDraws(int noOfDraws) {
        	this.noOfDraws = noOfDraws;
    	}
    	public void setNoOfDefeats(int noOfDefeats) {
        	this.noOfDefeats = noOfDefeats;
    	}
    	public void setGoalsFor(int goalsFor) {
        	this.goalsFor = goalsFor;
    	}
    	public void setGoalsAgainst(int goalsAgainst) {
        	this.goalsAgainst = goalsAgainst;
    	}
    	public void setPoints(int points) {
        	this.points = points;
    	}
    	public void setGoalDifference(int goalDifference){
        	this.goalDifference = goalDifference;
    	}
    	public int calculateGoalDifference(){
        	return this.goalsFor-this.goalsAgainst;
    	}
	//Overrinding toString method
    	@Override
    	public String toString() {
        	return  super.toString() +
                	", Played Matches=" + matchesPlayed + ", Wins=" + noOfWins +", Draws=" + noOfDraws +", Defeats=" + noOfDefeats
                	+", Points=" + points +", Goals For=" + goalsFor +", Goals Against="+goalsAgainst+", Goal Difference ="+goalDifference;
    	}
}
