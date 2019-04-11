package homework;

public final class Game {

    private static final String WINNING_ANNOTATION = "Win for ";
    private static final String ADVANTAGE_ANNOTATION = "Advantage ";
    private static final String DEUCE_ANNOTATION = "Deuce";
    private static final String ALL_ANNOTATION = "-All";
    private static final String SEPARATOR = "-";
    public static final int POINTS_FOR_DEUCE = 3;

    private final Player player1;
    private final Player player2;

    private Game(Player player1,Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    private String getScore(){
        if (this.checkForWinning()){
            return Game.WINNING_ANNOTATION + this.getLeadingPlayer().getName();
        }

        if (this.checkForAdvantage()){
            return Game.ADVANTAGE_ANNOTATION + this.getLeadingPlayer().getName();
        }

        if (this.player1.getPoints() == this.player2.getPoints() ) {
            if ( this.player1.getPoints() < Game.POINTS_FOR_DEUCE){
                return this.player1.getResult() + Game.ALL_ANNOTATION;
            }
            else{
                return Game.DEUCE_ANNOTATION;
            }
        }
        else{
            return this.player1.getResult() + Game.SEPARATOR + this.player2.getResult();
        }
    }

    private boolean checkForAdvantage(){
        return this.player1.hasAdvantage(this.player2)
                || this.player2.hasAdvantage(this.player1);
    }

    private boolean checkForWinning(){
        return this.player1.isWinning(this.player2)
                || this.player2.isWinning(this.player1);
    }

    private Player getLeadingPlayer(){
        if ( this.player1.getPoints() > this.player2.getPoints()){
            return this.player1;
        }
        return this.player2;
    }

    public static void main(String[] args) {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Game game = new Game(player1, player2);
        player1.increasePointsAndResult();
        player2.increasePointsAndResult();
        player2.increasePointsAndResult();
        System.out.println(game.getScore());
    }
}