package nucc.BattleShip.Game;

import nucc.BattleShip.Player.HumanPlayer;

public class Game{
    private HumanPlayer[] players;

    public Game(){
        players = new HumanPlayer[]{new HumanPlayer(1), new HumanPlayer(2)};
    }

    private boolean isGameRunning(){
        for(HumanPlayer player : players)
            if(player.getLivesLeft() == 0)
                return false;
        return true;
    }
    private void printGame(){
        System.out.println("=== Printing Boards ===");
        for(HumanPlayer player : players){
            System.out.println("\n\nPLayer "+player.getId()+":");
            player.getBoard().printBoard();
        }
    }
    public void start(){
        int i = 0, j = 1;
        int len = players.length;
        HumanPlayer current_player = null;

        for(HumanPlayer player : players) player.placeShips();
        System.out.println("\n\n");
        printGame();
        while(isGameRunning()){
            players[i++ %len].fireAt(players[j++ % len]);
            printGame();
            current_player = (players[0].getLivesLeft() < players[1].getLivesLeft())?
                players[1] : players[0];
        }
        System.out.println("Congrats player "+current_player.getId()+" you won");
    }
}