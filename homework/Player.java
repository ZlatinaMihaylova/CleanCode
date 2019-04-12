package main.homework;

import java.util.Arrays;

public final class Player {

    private static final int BEGINNING_POINTS = 0;
    private static final int WINNING_DIFFERENCE = 2;
    private static final int WINNING_POINTS = 4;

    private final String name;
    private int points;
    private String result;

    public Player(String name) {
        this.name = name;
        this.points = Player.BEGINNING_POINTS;
        this.result = new String();
    }

    void increasePointsAndResult(){
        this.points++;
        this.changeResult();
    }

    private void changeResult() {
        this.result = ScoringSystem.getResult(this.points);
    }

    boolean hasAdvantage(Player player){
        return this.hasMorePoints(player) && player.getPoints() >= Game.POINTS_FOR_DEUCE;
    }

    boolean isWinning(Player player){
        return this.points >= Player.WINNING_POINTS && (this.points - player.getPoints()) >= Player.WINNING_DIFFERENCE;
    }

    boolean hasMorePoints(Player player){
        return this.points > player.getPoints();
    }

    String getName() {
        return this.name;
    }

    String getResult() {
        return this.result;
    }

    int getPoints() {
        return this.points;
    }

    enum ScoringSystem{
        
        ZERO_POINTS_RESULT ("Love", 0),
        ONE_POINT_RESULT ("Fifteen", 1),
        TWO_POINTS_RESULT ("Thirty", 2),
        THREE_POINTS_RESULT ("Forty", 3);

        private String result;
        private int points;

        ScoringSystem(final String result, final int points) {
            this.result = result;
            this.points = points;
        }

        static String getResult(int points){
            return Arrays.stream(ScoringSystem.values())
                    .filter( scoringSystem -> scoringSystem.points == points)
                    .map( scoringSystem -> scoringSystem.result)
                    .findFirst()
                    .get();
        }
    }
}
