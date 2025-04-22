package zest;

public class Main {
    public static void main(String[] args) {
        ClimbingStairs climber = new ClimbingStairs();
        int steps = 10;
        
        long ways = climber.climbStairs(steps);
        System.out.println("Number of ways to climb " + steps + " steps: " + ways);
    }
}

