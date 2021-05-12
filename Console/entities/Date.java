package entities;
import java.io.Serializable;
import java.util.Objects;

public class Date implements Comparable<Date>, Serializable {
	//Instance Variables
	private int day;
    	private int month;
    	private int year;
	
	//Constructor
    	public Date(int day,int month,int year){
        	this.day = day;
        	this.month = month;
        	this.year = year;
    	}
	//Getter Methods
    	public int getDay() {
        	return day;
    	}	
    	public int getMonth() {
        	return month;
    	}
    	public int getYear() {
        	return year;
    	}
	//Setter Methods
    	public void setDay(int day) {
        	this.day = day;
    	}
    	public void setMonth(int month) {
        	this.month = month;
    	}
    	public void setYear(int year) {
        	this.year = year;
    	}
	//Overrinding toString method
    	@Override
    	public String toString() {
        	return "Date{day=" + day +", month=" + month +", year=" + year +'}';
    	}
	//Overrinding comapareTo method
    	@Override
    	public int compareTo(Date o) {
        	return this.getDateInMinutes()-o.getDateInMinutes();
    	}
	//Overriding equals method
    	@Override
    	public boolean equals(Object o) {
        	if (this == o) return true;
        	if (o == null || getClass() != o.getClass()) return false;
        	Date date = (Date) o;
        	return day == date.day &&
                	month == date.month &&
                	year == date.year;
    	}
	//Overriding hashCode method
    	@Override
    	public int hashCode() {
        	return Objects.hash(day, month, year);
    	}
	//Converting date to mintues
    	private int getDateInMinutes(){
        	return (this.year * 365 *24 * 60) + (this.month*30*24*60)+(this.day*24*60);
    	}
}

