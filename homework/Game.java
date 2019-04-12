package main.homework;

public final class Game {

    private static final String WINNING_ANNOTATION = "Win for ";
    private static final String ADVANTAGE_ANNOTATION = "Advantage ";
    private static final String DEUCE_ANNOTATION = "Deuce";
    private static final String ALL_ANNOTATION = "-All";
    private static final String SEPARATOR = "-";
    public static final int POINTS_FOR_DEUCE = 3;

    private final Player firstPlayer;
    private final Player secondPlayer;

    private Game(Player firstPlayer,Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    private String getResult(){
        if (this.checkForWinning()){
            return Game.WINNING_ANNOTATION + this.getLeadingPlayer().getName();
        }
        if (this.checkForAdvantage()){
            return Game.ADVANTAGE_ANNOTATION + this.getLeadingPlayer().getName();
        }
        if (this.arePointsEquals()) {
            return this.getEqualPointsResult();
        }
        return this.firstPlayer.getResult() + Game.SEPARATOR + this.secondPlayer.getResult();
    }

    private String getEqualPointsResult(){
        if ( this.firstPlayer.getPoints() < Game.POINTS_FOR_DEUCE){
            return this.firstPlayer.getResult() + Game.ALL_ANNOTATION;
        }
        return Game.DEUCE_ANNOTATION;
    }

    private boolean arePointsEquals(){
        return this.firstPlayer.getPoints() == this.secondPlayer.getPoints();
    }

    private boolean checkForAdvantage(){
        return this.firstPlayer.hasAdvantage(this.secondPlayer)
                || this.secondPlayer.hasAdvantage(this.firstPlayer);
    }

    private boolean checkForWinning(){
        return this.firstPlayer.isWinning(this.secondPlayer)
                || this.secondPlayer.isWinning(this.firstPlayer);
    }

    private Player getLeadingPlayer(){
        if ( this.firstPlayer.hasMorePoints(this.secondPlayer)){
            return this.firstPlayer;
        }
        return this.secondPlayer;
    }

    public static void main(String[] args) {
        Player firstPlayer = new Player("firstPlayer");
        Player secondPlayer = new Player("secondPlayer");
        Game game = new Game(firstPlayer, secondPlayer);
        firstPlayer.increasePointsAndResult();
        firstPlayer.increasePointsAndResult();
        secondPlayer.increasePointsAndResult();
        System.out.println(game.getResult());
    }
}
