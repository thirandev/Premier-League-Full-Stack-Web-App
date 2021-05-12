package entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {
    Date date = new Date(0,0,0);
    @Test
    public void testDate(){
        //The Test Checks if the setter and getters functions properly.
        //To pass the test the passTest variable must be 3,which is equal to the number of
        // instance variables in the Date class.
        int passTest = 0;
        int [] testDate = {11,5,20200};
        date.setDay(testDate[0]);
        date.setMonth(testDate[1]);
        date.setYear(testDate[2]);

        if (date.getDay() == testDate[0]){passTest++;}
        if (date.getMonth() == testDate[1]){passTest++;}
        if (date.getYear() == testDate[2]){passTest++;}
        assertEquals(3,passTest);
    }
}