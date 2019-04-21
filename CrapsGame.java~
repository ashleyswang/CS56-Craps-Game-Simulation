public class CrapsGame{

    private int numOfRolls = 0;
    private CrapsMetricMonitor monitor;

    // Constructor
    public CrapsGame(CrapsMetricsMonitor monitor) 
    {
	this.monitor = monitor; 
    }

    // Accessor & Mutators
    public int getNumOfRolls() { return numOfRolls; }
    public void resetNumOfRolls() { numOfRolls = 0; }

    // Game Algorithm
    public boolean playGame()
    {
	boolean playing = true;
	int roll = (int)(Math.random()*6 + 1) + (int)(Math.random()*6 + 1);
	numOfRolls++;
	System.out.println("Rolled a " + roll);

	if(sum == 7 || sum == 11){
	    System.out.println("*****Natural! You win!*****");
	    monitor.setNaturalCount();
	    return true;
	
	} else if(sum == 2 || sum == 3 || sum == 12){
	    System.out.println("*****Craps! You loose.*****");
	    monitor.setCrapsCount();
	    return false; 
	    
	} while(playing){
	    int newRoll = (int)(Math.random()*6 +1) + (int)(Math.random()*6 +1);
	    numOfRolls++;
	    System.out.println("Rolled a " + newRoll);
	    
	    if(newRoll == roll){
		System.out.println("*****Rolled the point! You win!*****");
		return true;
		
	    }else if(newRoll == 7) {
		System.out.println("*****Crap out! You loose.*****"); 
		return false; 
	    }
	}
    }
}