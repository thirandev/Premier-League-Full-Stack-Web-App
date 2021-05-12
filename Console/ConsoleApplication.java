import entities.*;
import java.util.List;
import java.util.Scanner;
import java.net.URI;


public class ConsoleApplication {

	//Creating a PremierLeagueManager Object using getInstance.
    	static LeagueManager manager = PremierLeagueManager.getInstance();

    	public static void main(String [] args){

        	Scanner scanner = new Scanner(System.in);
		//Naming the file location to store data.
        	String fileName = "../PremierLeagueCLubData.txt";
        	String fileName2 = "../MatchData.txt";
		//Load Data
        	manager.loadFile(fileName);
        	manager.loadMatches(fileName2);
        	menuLoop:
        	while (true){
            		displayMenu();
            		int choice = 0;
            		boolean flag = false;
            		do {
                		System.out.println("Enter selected number :");
                		String stringInt = scanner.nextLine();
                		flag = stringInt.matches("^[0-9]*$");
                		if(!flag){
                    			System.out.println("Invalid Number Format.");
                		}else{
                    			choice = Integer.parseInt(stringInt);
                		}
            		}while (!flag);

            		switch (choice){
                		case 1:
                   			createClub(scanner);
                    			break;
                		case 2:
					//Relegate a Club
                    			manager.deleteFootballClub();
                    			break;
                		case 3:
                    			displayStats(scanner);
                    			break;
                		case 4:
					//Display Premier League Table
                    			manager.displayLeagueTable();
                    			break;
                		case 5:
                    			addMatch(scanner);
                    			break;
                		case 6:
					//Save data
                    			manager.saveToFile(fileName);
                    			manager.saveMatches(fileName2);
                    			break;
				case 7:
					openGui();
					break;
                		case 8:
                    			System.out.println("Thank You for using the Application.");
					//Save data
                    			manager.saveToFile(fileName);
                    			manager.saveMatches(fileName2);
                    			break menuLoop;
                		default:
                    			System.out.println("You Selected an Invalid Option. Please Try Again!");
            		}
        	}
    	}
    	public static void displayMenu(){
        	System.out.println("\nWelcome to the Premier League Manager");
        	System.out.println("1: Create a new Football Club.");
        	System.out.println("2: Relegate an existing club from the Premier League");
        	System.out.println("3: Display Statistics for a selected Club.");
       		System.out.println("4: Display the Premier League Table.");
        	System.out.println("5: Add a played match.");
        	System.out.println("6: Save to file.");
		System.out.println("7: Open GUI");
        	System.out.println("8: Quit the Application");
    	}

    	private static void createClub(Scanner scanner) {
		//Getting user input to create a football club.

        	boolean flag;
        	String clubName;
        	String location;
        	int matchesPlayed = 0;
        	int noOfWins = 0;
        	int noOfDraws = 0;
        	int noOfDefeats = 0;
        	int goalsFor = 0 ;
        	int goalsAgainst = 0;
        	do {
            		System.out.println("Enter the name of the Club: ");
            		clubName = scanner.nextLine().toLowerCase();
            		flag = clubName.matches("^(?![\\s.]+$)[a-zA-Z\\s.]*$");
            		if (!flag) System.out.println("Invalid Input.");
        	}while (!flag);

        	do {
            		System.out.println("Enter the location of the Club: ");
            		location = scanner.nextLine().toLowerCase();
            		flag = location.matches("^(?![\\s.]+$)[a-zA-Z\\s.]*$");
            		if (!flag) System.out.println("Invalid Input.");
        	}while (!flag);

        	do {
            		System.out.println("Enter the number of matches played by the Club: ");
            		String stringInt = scanner.nextLine();
            		flag = stringInt.matches("^[0-9]*$");
            		if(!flag){
                		System.out.println("Invalid Number.");
            		}else{
                		matchesPlayed = Integer.parseInt(stringInt);
            		}
        	}while (!flag);

        	do {
            		System.out.println("Enter the number of wins by the Club: ");
            		String stringInt = scanner.nextLine();
            		flag = stringInt.matches("^[0-9]*$");
            		if(!flag){
                		System.out.println("Invalid Number.");
            		}else{
                		noOfWins = Integer.parseInt(stringInt);
            		}
        	}while (!flag);

        	do {
            		System.out.println("Enter the number of draws by the Club: ");
            		String stringInt = scanner.nextLine();
            		flag = stringInt.matches("^[0-9]*$");
            		if(!flag){
                		System.out.println("Invalid Number.");
            		}else{
                		noOfDraws = Integer.parseInt(stringInt);
            		}
        	}while (!flag);

        	do {
            		System.out.println("Enter the number of defeats by the Club: ");
            		String stringInt = scanner.nextLine();
            		flag = stringInt.matches("^[0-9]*$");
            		if(!flag){
                		System.out.println("Invalid Number.");
            		}else{
                		noOfDefeats = Integer.parseInt(stringInt);
            		}
        	}while (!flag);

        	do {
           		 System.out.println("Enter the number of goals scored by the Club: ");
            		String stringInt = scanner.nextLine();
            		flag = stringInt.matches("^[0-9]*$");
            		if(!flag){
                		System.out.println("Invalid Number.");
            		}else{
                		goalsFor = Integer.parseInt(stringInt);
            		}
        	}while (!flag);

        	do {
            		System.out.println("Enter the number of goals against the Club: ");
            		String stringInt = scanner.nextLine();
            		flag = stringInt.matches("^[0-9]*$");
            		if(!flag){
                		System.out.println("Invalid Number.");
            		}else{
                		goalsAgainst = Integer.parseInt(stringInt);
            		}
        	}while (!flag);
		//Calculating the number of points
        	int points = noOfWins*3+noOfDraws*1;
		//Calculating the goal difference
        	int goalDifference = goalsFor - goalsAgainst;
		//Making a footbool object
        	SportsClub club = new FootballClub(clubName,location,matchesPlayed,noOfWins,noOfDraws,
                	noOfDefeats,goalsFor,goalsAgainst,goalDifference,points);
		//Passing the created club object as a parameter to add to the premier league.
        	manager.addFootballClub(club);
    	}
    	private static void displayStats(Scanner scanner) {
		//Displays statistics of the user input
        	String  clubName;
        	boolean flag;
        	do {
            		System.out.println("Please Enter the Club Name to display Statistics.");
            		clubName = scanner.nextLine().toLowerCase();
            		flag = clubName.matches("^(?![\\s.]+$)[a-zA-Z\\s.]*$");
            		if (!flag) System.out.println("Invalid Input.");
        	}while (!flag);
        	manager.displayClubStatistics(clubName);
    	}
    	private static void addMatch(Scanner scanner) {
		//Adding a match the user input
        	boolean flag;
        	int day = 0;
        	int month =0;
        	int year =0;
        	String[] clubs = new String[2];
        	int [] scores = new int[2];

        	List<SportsClub> checkList=manager.sortPremierLeagueClubs();
       		System.out.println("Teams currently in the League");
        	for (SportsClub sportsClub : checkList) {
           		 System.out.print(sportsClub.getClubName()+"  ");
        	}

        	do {
           		 System.out.println("\nEnter Day of the Match: (DD)");
            		String stringInt = scanner.nextLine();
            		flag = stringInt.matches("^(3[01]|[12][0-9]|0[1-9])$");
            		if(!flag){
                		System.out.println("Invalid Day.");
            		}else{
                		day = Integer.parseInt(stringInt);
            		}
        	}while (!flag);

        	do {
            		System.out.println("Enter Month of the Match: (MM)");
           		 String stringInt = scanner.nextLine();
            		flag = stringInt.matches("^(1[0-2]|[1-9])$");
            		if(!flag){
                		System.out.println("Invalid Month.");
            		}else{
                		month = Integer.parseInt(stringInt);
            		}
        	}while (!flag);

        	do {
           		 System.out.println("Enter Year of the Match: (YYYY)");
            		String stringInt = scanner.nextLine();
            		flag = stringInt.matches("^\\d{4}");
            		if(!flag){
                		System.out.println("Invalid Year.");
            		}else{
                		year = Integer.parseInt(stringInt);
            		}
        	}while (!flag);

        	do {
            		System.out.println("Enter Club 1 name: ");
            		clubs[0] = scanner.nextLine().toLowerCase();
            		flag = clubs[0].matches("^(?![\\s.]+$)[a-zA-Z\\s.]*$");
            		if (!flag) System.out.println("Invalid Input.");
        	}while (!flag);

        	do {
            		System.out.println("Enter Club 1 score: ");
            		String stringInt = scanner.nextLine();
            		flag = stringInt.matches("^[0-9]*$");
            		if(!flag){
                		System.out.println("Invalid Year.");
            		}else{
                		scores[0] = Integer.parseInt(stringInt);
            		}
        	}while (!flag);

        	do {
            		System.out.println("Enter Club 2 name: ");
            		clubs[1] = scanner.nextLine().toLowerCase();
            		flag = clubs[1].matches("^(?![\\s.]+$)[a-zA-Z\\s.]*$");
            		if (!flag) System.out.println("Invalid Input.");
        	}while (!flag);

        	do {
            		System.out.println("Enter Club 2 score: ");
            		String stringInt = scanner.nextLine();
            		flag = stringInt.matches("^[0-9]*$");
            		if(!flag){
                		System.out.println("Invalid Year.");
            	}else{
                	scores[1] = Integer.parseInt(stringInt);
            	}
        	}while (!flag);
		//Passing the parameters to add a match.
       		manager.addPlayedMatch(new Date(day,month,year),clubs,scores);
    	}
	private static void openGui() {
        	//http request link to open gui
        	String url = "http://localhost:3000/";
        	try{
            	//opens the browser and directs to gui url
            	java.awt.Desktop.getDesktop().browse(URI.create(url));
        	}catch (Exception e){
            		System.out.println("Error when loading UI: " + e.getMessage());
        	}
    	}
}
