package nucc.BattleShip.Game;

import nucc.BattleShip.Player.HumanPlayer;

public class Game{
    private HumanPlayer[] players;

    public Game(){
        players = new HumanPlayer[]{new HumanPlayer(1), new HumanPlayer(2)};
    }

    public boolean isGameRunning(){
        for(HumanPlayer player : players)
            if(player.getLivesLeft() == 0)
                return false;
        return true;
    }
    public void start(){
        int i = 0, j = 1;
        int len = players.length;
        HumanPlayer current_player = null;

        for(HumanPlayer player : players) player.placeShips();
        while(isGameRunning()){
            players[i++ %len].fireAt(players[j++ % len]);
            for(HumanPlayer player : players){
                System.out.println("PLayer "+player.getId()+":");
                player.getBoard().printBoard();
            }

            current_player = (players[0].getLivesLeft() < players[1].getLivesLeft())?
                players[1] : players[0];
        }
        System.out.println("Congrats player "+current_player.getId()+" you won");
    }
}