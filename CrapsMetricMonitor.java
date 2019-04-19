public class CrapsMetricMonitor{

  private int gamesPlayed, gamesWon, gamesLost, maxRolls, naturalCount, crapsCount, winStreak, loseStreak, maxWinStreak, maxLoseStreak, maxBalance, maxBalanceGame;
 
  // Accessors
  public int getGamesPlayed(){ return gamesPlayed; }
  public int getGamesWon(){ return gamesWon; }
  public int getGamesLost(){ return gamesLost; }
  public int getMaxRolls(){ return maxRolls; }
  public int getNaturalCount(){ return naturalCount; }
  public int getCrapsCount(){ return crapsCount; 
  public int getMaxWinStreak(){ return maxWinStreak; }
  public int getMaxLoseStreak(){ return maxLoseStreak; }
  public int getMaxBalance(){ return maxBalance; }
  public int getMaxBalanceGame(){ return maxBalanceGame; }
    
  // Modifiers
  
  
  // Other Functions
  public void printStatistics(){
    System.out.println("*****************************");
    System.out.println("*** SIMULATION STATISTICS ***");
    System.out.println("*****************************");
    System.out.println("Games played: " + gamesPlayed);
    System.out.println("Games won: " + gamesWon);
    System.out.println("Games lost: " + gamesLost);
    System.out.println("Maximum Rolls in a single game: " + maxRolls);
    System.out.println("Natural Count: " + naturalCount);
    System.out.println("Craps Count: " + crapsCount);
    System.out.println("Maximum Winning Streak" + maxWin);
    System.out.println("Maximum Loosing Streak" + maxLose);
    System.out.println("Maximum balance: " + maxBalance + " during game " + maxBalanceGame);
  }
  
  public void reset(){
    gamesPlayed = 0; 
    gamesWon = 0; 
    gamesLost = 0; 
    maxRolls = 0;  
    naturalCount = 0; // number of times you win on the first roll 
    crapsCount = 0; // lose on the first roll
    maxWinStreak = 0; 
    maxLoseStreak = 0;  
    maxBalance = 0;  
    maxBalanceGame= 0;
  }
