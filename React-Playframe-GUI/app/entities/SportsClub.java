package entities;
import java.io.Serializable;
import java.util.Objects;

public abstract class SportsClub implements Serializable{
	//Instance Variables
	private String clubName;
	private String clubLocation;
	
	//Constructor
	public SportsClub(String clubName, String clubLocation){
		this.clubName = clubName;
		this.clubLocation = clubLocation;
	}
	
	//Getter Methods

    	public String getClubName(){
        	return clubName;
    	}
    	public String getClubLocation(){
        	return clubLocation;
    	}

	//Setter Methods
	
    	public void setClubName(String name){
        	this.clubName = name;
    	}
    	public void setClubLocation(String location){
        	this.clubLocation = location;
    	}
	
	//Overriding equals method
    	@Override
    	public boolean equals(Object o) {
        	if(this == o){
            		return true;
        	}
        	if (o == null){
            		return false;
        	}if ((o instanceof SportsClub) && ((SportsClub) o).getClubName().equals(clubName)) {
            		return true;
        	} else {
            		return false;
        	}
    	}
	
	//Overriding hashCode method
    	@Override
    	public int hashCode() {
        	return Objects.hash(clubName, clubLocation);
    	}
	
	//Overrinding toString method
    	@Override
    	public String toString() {
        	return "Club Name=" + clubName +", Club Location=" + clubLocation;
	}
}

