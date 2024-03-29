import java.util.Scanner;

public class CrapsSimulation{

    private CrapsGame game;
    private CrapsMetricMonitor monitor;
    private String name; 
    private int balance; 
    private int betAmount; 
    private int winStreak;
    private int loseStreak;
    private Scanner s;
    
    // Constructor
    public CrapsSimulation() {
	monitor = new CrapsMetricMonitor();
	game = new CrapsGame(monitor);
	winStreak = 0;
	loseStreak = 0;
	s = new Scanner(System.in);
    }

    // Simulation Algorithm 
    public void start() {
	boolean win; 
	// User Input
	System.out.print("Welcome to SimCraps! Enter your user name: ");
	name = s.nextLine();
	while(true) 
	    {
		if(!name.contains(" "))
		    break;
		System.out.println("Invalid, please enter username without whitespaces");
		name = s.nextLine();
	    }

	System.out.println("Hello " + name + "!");

	System.out.print("Enter the amount of money you will bring to the table: ");
	balance = s.nextInt();
	while(balance < 1) {
	    System.out.print("Invalid amount! Please enter an amount greater than 0: ");
	    balance = s.nextInt();
	} 

	System.out.print("Enter the bet amount between $1 and $" + balance + ": ");
	betAmount = s.nextInt();

	while(betAmount > balance || betAmount < 1) {
	    System.out.print("Invalid bet! Please enter a bet between $1 and " + balance + ".");
	    betAmount = s.nextInt();
	} 

	// Start Game Play
	monitor.setMaxBalance(balance);
	monitor.setMaxBalanceGame(1);

	int originalBet = betAmount;

	while(balance > 0) {
	    //win = game.playGame();
	    monitor.setGamesPlayed();

	    if(betAmount > balance && balance > 0){
		betAmount = balance;

	    } if (originalBet > betAmount && balance > 0 && balance > betAmount) {
		if (originalBet >= balance)
		    betAmount = balance;
		else
		    betAmount = originalBet;
	    }
	    System.out.println(name + " bets $" + betAmount); 
	    win = game.playGame();

	    if(balance > monitor.getMaxBalance()) {
		monitor.setMaxBalance(balance);
		monitor.setMaxBalanceGame(monitor.getGamesPlayed());

	    }if(game.getNumOfRolls() > monitor.getMaxRolls()){
		monitor.setMaxRolls(game.getNumOfRolls());

	    }if(win){
		winStreak++;
		monitor.setGamesWon();
		if(winStreak > monitor.getMaxWinStreak()){
		    monitor.setMaxWinStreak(winStreak);
		}
		loseStreak = 0;
		balance += betAmount;
		game.resetNumOfRolls();
	    
	    }else if(!win){
		loseStreak++; 
		monitor.setGamesLost();
		if(loseStreak > monitor.getMaxLoseStreak()){
		    monitor.setMaxLoseStreak(loseStreak);
		}
		winStreak = 0;
		balance -= betAmount;
		game.resetNumOfRolls();
	    }
	    if(balance > 0){
		System.out.println(name + "'s balance: " + balance + ". Playing a new game...");
		//System.out.println(name + " bets $" + betAmount);
	    }else
		System.out.println(name + "'s balance: " + balance + ". End of game");


	}

	monitor.printStatistics();

	// Replay?
	boolean response = true;
	System.out.print("Replay? Enter 'y' or 'n': ");
	String replay = s.next();

	while( response ) {
	    if(replay.charAt(0) == 'y'){
		response = false;
		CrapsSimulation simulation = new CrapsSimulation();
		simulation.start();
	    }else if(replay.charAt(0) == 'n'){
		System.out.println("Thanks for playing!");
		response = false;

	    }else {
		System.out.println("Please enter a valid response.");
		replay = s.next();
		//response = true;
	    }
	}
	s.close();
    }
}
