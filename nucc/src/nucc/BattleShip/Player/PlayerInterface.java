package nucc.BattleShip.Player;

public interface PlayerInterface{
    void placeShips();
    void fireAt(PlayerInterface opponent);
    int getLivesLeft();
}