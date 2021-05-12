package entities;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PremierLeagueManager implements LeagueManager {

    	private static LeagueManager manager = null;

    	//Maximum number of teams in Premier League.
    	public static final int MAX_NO_CLUBS = 20;
    	//Instance Variable that holds the number of free spaces inside the League.
    	private int availableSpace = MAX_NO_CLUBS;

    	//List to hold all Premier league clubs.
    	private List <SportsClub> premierLeagueClubs = new ArrayList<>();
    	//List to hold all Premier league clubs.
   	private List <Match> matchList = new ArrayList<>();

    	private PremierLeagueManager(){}

    	public static LeagueManager getInstance(){
        	if (manager == null){
            		synchronized (PremierLeagueManager.class){
                		if (manager == null){
                    			manager = new PremierLeagueManager();
                		}
            		}
        	}
        	return manager;
    	}

    	@Override
    	public void addFootballClub(SportsClub sportsClub) {
        	if(availableSpace == 0){
            		//Checks for league space availability.
            		System.out.printf("All %s clubs are filled in the Premier League.\n",MAX_NO_CLUBS);
        	}else if (premierLeagueClubs.contains(sportsClub)){
            		//Checks if the club is existing in the League.
            		System.out.println("This Club is already registered to the Premier League");
        	}else {
            		//Add the club to the list and reduce the available space in the league.
            		premierLeagueClubs.add(sportsClub);
            		System.out.printf("%s is now Registered to the Premier League\n",sportsClub.getClubName());
            		availableSpace -= 1;
            		System.out.println(availableSpace>0?"Available Club Space: "+availableSpace:"The clubs are filled in the Premier League");
        	}
    	}

    	@Override
    	public void deleteFootballClub() {
        	boolean exist = false;
        	if(premierLeagueClubs.isEmpty()) {
            		//Checks if the list is empty.
            		System.out.println("No Clubs are registered to the Premier League at the Moment!");
        	}else {
            		//Sorting the Premier League Club list in ascending order according to club statistics.
            		Collections.sort(premierLeagueClubs, new StatisticsComparator());
            		System.out.printf("%s is relegated to  EFL Championship.\n",premierLeagueClubs.get(0).getClubName());
            		//Removes the club that had the lowest points from the list.
            		premierLeagueClubs.remove(0);
            		//Increase club space slots.
            		availableSpace += 1;
        	}
    	}

    	@Override
    	public void displayClubStatistics(String clubName) {
        	boolean exist = false;
        	if(premierLeagueClubs.isEmpty()) {
            		//Checks if the list is empty.
            		System.out.println("No Clubs are registered to the Premier League at the Moment!");
        	}else {
            		//Enhanced For Loop to iterate through the League List.
            		for (SportsClub sportsClub : premierLeagueClubs) {
                		if (sportsClub.getClubName().equals(clubName)) {
                    		//Checks for the matching club name.
                    		exist = true;
                    		//Prints the sports club object.
                    		System.out.println(sportsClub);
                    		break;
                		}
            		}
            		if (!exist) {
                		System.out.println("The club doesn't exist in the Premier League.");
            		}

        	}
    	}

    	@Override
    	public void displayLeagueTable() {
        	if(premierLeagueClubs.isEmpty()) {
            		//Checks if the list is empty.
            		System.out.println("No Clubs are registered to the Premier League at the Moment!");
        	}else {
            		//Collections.sort method is sorting the elements of ArrayList in ascending order.
            		//Sorts the specified list according to the order induced by the specified comparator.
            		//.reversed() makes the list in the descending order.
            		Collections.sort(premierLeagueClubs, new StatisticsComparator().reversed());
            		//Enhanced For Loop to iterate through the League List.
            		for (SportsClub sportsClub : premierLeagueClubs) {
                		//Prints the sports club object.
                		System.out.println(sportsClub);
            		}
        	}
    	}
    	@Override
    	public void addPlayedMatch(Date date, String[] clubs, int[] scores) {
        	boolean exist = false;
        	SportsClub club1 = null;
        	SportsClub club2 = null;
        	Match match;
        	if (premierLeagueClubs.size() < 1) {
            		//Checks if the list is empty.
            		System.out.println("Limited no Clubs are registered to the Premier League at the Moment!");
        	} else if(clubs[0].equals(clubs[1])) {
            		System.out.println("Both clubs cannot be equal.");
        	}else {
            		for (SportsClub sportsClub : premierLeagueClubs) {
                		if (sportsClub.getClubName().equals(clubs[0])) {
                   			club1 = sportsClub;
                    			for (SportsClub sportsClub1 : premierLeagueClubs){
                        			if (sportsClub1.getClubName().equals(clubs[1])) {
                            			club2 = sportsClub1;
                            			exist = true;
                           			 break;
                        		}
                    		}		
                	}
            	}
            	if (exist) {
                	match = new Match(date,club1,club2,scores[0],scores[1]);
                	updateStatistics(match);
                	matchList.add(match);
                	System.out.println(match.toString());
            	}
            	else {
                		System.out.println("The clubs doesn't exist in the Premier League.");
            	}	

        	}
    	}
    	public void updateStatistics(Match match){
       		FootballClub f1 = (FootballClub) match.getTeam1();
        	FootballClub f2= (FootballClub) match.getTeam2();

        	f1.setMatchesPlayed(f1.getMatchesPlayed()+1);
        	f2.setMatchesPlayed(f2.getMatchesPlayed()+1);

        	int score1 = match.getScore1();
        	int score2 = match.getScore2();

        	if (score1 == score2){
            		//Updates the number of draws of the two clubs.
            		f1.setNoOfDraws(f1.getNoOfDraws()+1);
            		f2.setNoOfDraws(f2.getNoOfDraws()+1);

            		//Updates the number of points of the two clubs.
            		f1.setPoints(f1.getPoints()+1);
            		f2.setPoints(f2.getPoints()+1);
        	}else if (score1>score2){
            		//Updates the number of draws of the two clubs.
            		f1.setNoOfWins(f1.getNoOfWins()+1);
            		f2.setNoOfDefeats(f2.getNoOfDefeats()+1);

            		//Updates the number of points of the two clubs.
            		f1.setPoints(f1.getPoints()+3);

        	}else {
            		//Updates the number of draws of the two clubs.
            		f2.setNoOfWins(f2.getNoOfWins()+1);
            		f1.setNoOfDefeats(f1.getNoOfDefeats()+1);

            		//Updates the number of points of the two clubs.
            		f2.setPoints(f2.getPoints()+3);

        	}
        		//Updates the number of points of the two clubs.
        		f1.setGoalsFor(f1.getGoalsFor()+score1);
        		f2.setGoalsFor(f2.getGoalsFor()+score2);

        		//Updates the number of points of the two clubs.
        		f1.setGoalsAgainst(f1.getGoalsAgainst()+score2);
        		f2.setGoalsAgainst(f2.getGoalsAgainst()+score1);

        		//Updates the number of points of the two clubs.
        		f1.setGoalDifference(f1.calculateGoalDifference());
        		f2.setGoalDifference(f2.calculateGoalDifference());
    	}

    	public Match generateMatch(){
        	Random random = new Random();
        	SportsClub club1;
        	SportsClub club2 ;
        	Match match = null;
        
        	int score1 ;
        	int score2 ;
        	int index1;
        	int index2;
        
        	boolean flag = false;

        	LocalDate currentDate = LocalDate.now();
        	int currentDay = currentDate.getDayOfMonth();
        	int currentMonth = currentDate.getMonthValue();
        	int currentYear = currentDate.getYear();
        	Date matchDate = new Date(currentDay,currentMonth,currentYear);

        	do {
            		index1 = random.nextInt(premierLeagueClubs.size());
            		club1 = premierLeagueClubs.get(index1);
            		index2 = random.nextInt(premierLeagueClubs.size());
            		score1 = random.nextInt(20);
            		score2 = random.nextInt(20);
            		if (index1 != index2) {
                		flag = true;
                		club2 = premierLeagueClubs.get(index2);
                		match = new Match(matchDate, club1, club2, score1, score2);
                		matchList.add(match);
                		updateStatistics(match);
            		}
        	} while (!flag);

        	return match;
    	}
    	@Override
    	public void saveToFile (String fileName){
        	try {
            		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
           		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            		for (SportsClub sClub : premierLeagueClubs) {
                		objectOutputStream.writeObject(sClub);
            		}
            		objectOutputStream.flush();
            		fileOutputStream.close();
            		objectOutputStream.close();
            		System.out.println("Data has been successfully saved to the file.");
        	} catch (FileNotFoundException e) {
            		System.out.println("File not found");
        	} catch (IOException e) {
            		System.out.println("Error initializing stream");
        	}
    	}

    	@Override
    	public void saveMatches(String fileName){
        	try {
            		FileOutputStream fileOut = new FileOutputStream(fileName);
            		ObjectOutputStream objectOutput = new ObjectOutputStream(fileOut);

            		for (Match match : matchList) {
                		objectOutput.writeObject(match);
            		}
            		objectOutput.flush();
            		fileOut.close();
            		objectOutput.close();
           		System.out.println("Match Data has been successfully saved to the file.");
        	} catch (FileNotFoundException e) {
           		 System.out.println("File not found");
       		} catch (IOException e) {
           		 System.out.println("Error initializing stream");
        	}
    	}

    	@Override
    	public void loadFile (String fileName){
        	premierLeagueClubs.clear();
        	FileInputStream fileInputStream = null;
        	ObjectInputStream objectInputStream = null;
        	try {
            		fileInputStream = new FileInputStream(fileName);
            		objectInputStream = new ObjectInputStream(fileInputStream);
            		for (; ; ) {
                		try {
                   			SportsClub sportsClub = (SportsClub) objectInputStream.readObject();
                    			premierLeagueClubs.add(sportsClub);

                		} catch (EOFException e) {
                    			break;
                		}
            		}
        	} catch (FileNotFoundException e) {
            		System.out.println("A File Not Found Exception has occurred.");
        	} catch (IOException e) {
            		System.out.println("An I/O Exception has occurred.");
        	} catch (Exception e) {
            		System.out.println("An Exception has occurred.");
        	} finally {
            		try {
                		fileInputStream.close();
                		objectInputStream.close();
                		System.out.println("Data has been Successfully loaded from the file.");
            		} catch (NullPointerException | IOException npe) {
                		System.out.println("An Exception has occurred");
            		}
        	}
    	}

    	@Override
    	public void loadMatches(String fileName) {
        	matchList.clear();
        	FileInputStream fileInputStream2 = null;
        	ObjectInputStream objectInputStream2 = null;
        	try {
            		fileInputStream2 = new FileInputStream(fileName);
            		objectInputStream2 = new ObjectInputStream(fileInputStream2);
            		for (; ; ) {
                		try {
                    			Match match = (Match) objectInputStream2.readObject();
                    			matchList.add(match);

                		} catch (EOFException e) {
                    			break;
                		}
            		}
       	 	} catch (FileNotFoundException e) {
            		System.out.println("A File Not Found Exception has occurred.");
        	} catch (IOException e) {
            		System.out.println("An I/O Exception has occurred.");
        	} catch (Exception e) {
            		System.out.println("An Exception has occurred.");
        	} finally {
            		try {
                		fileInputStream2.close();
                		objectInputStream2.close();
                		System.out.println("Match data has been Successfully loaded from the file.");
            		} catch (NullPointerException | IOException npe) {
                		System.out.println("An Exception has occurred");
            		}
        	}
    	}

    	@Override
    	public List<Match> sortedMatchList() {
        	Collections.sort(matchList, new DateComparator());
        	return matchList;
    	}
   	@Override
    	public List<SportsClub> sortPremierLeagueClubs() {
        	Collections.sort(premierLeagueClubs, new StatisticsComparator().reversed());
        	return premierLeagueClubs;
    	}
    	@Override
    	public List<SportsClub> sortPremierLeagueClubsByGoals(){
        	Collections.sort(premierLeagueClubs, new GoalsForComparator().reversed());
        	return premierLeagueClubs;
    	}
    	@Override
    	public List<SportsClub> sortPremierLeagueClubsByWins(){
        	Collections.sort(premierLeagueClubs, new WinsComparator().reversed());
        	return premierLeagueClubs;
    	}
}
