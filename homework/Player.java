package homework;

public final class Player {

    private static final int BEGINNING_POINTS = 0;
    private static final String ZERO_POINTS_RESULT = "Love";
    private static final String ONE_POINT_RESULT = "Fifteen";
    private static final String TWO_POINTS_RESULT = "Thirty";
    private static final String THREE_POINTS_RESULT = "Forty";
    private static final int WINNING_DIFFERENCE = 2;
    private static final int WINNING_POINTS = 4;

    private final String name;
    private String result;
    private int points;

    public Player(String name) {
        this.name = name;
        this.result = "";
        this.points = Player.BEGINNING_POINTS;
    }

    private void changeResult() {
        switch(this.points){
            case 0:
                this.result = Player.ZERO_POINTS_RESULT;
                break;
            case 1:
                this.result = Player.ONE_POINT_RESULT;
                break;
            case 2:
                this.result = Player.TWO_POINTS_RESULT;
                break;
            case 3:
                this.result = Player.THREE_POINTS_RESULT;
                break;
        }
    }

    boolean hasAdvantage(Player player){
        return this.hasMorePoints(player) && player.getPoints() >= Game.POINTS_FOR_DEUCE;
    }

    boolean isWinning(Player player){
        return this.points >= Player.WINNING_POINTS && (this.points - player.getPoints()) >= Player.WINNING_DIFFERENCE;
    }

    private boolean hasMorePoints(Player player){
        return this.points > player.getPoints();
    }

    void increasePointsAndResult(){
        this.points++;
        this.changeResult();
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
}
