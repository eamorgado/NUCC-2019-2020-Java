package nucc.BattleShip.Player;

import java.awt.*;
import java.util.Scanner;

import nucc.BattleShip.Board.Board;
import nucc.BattleShip.Results.State;
import nucc.BattleShip.Player.PlayerInterface;

public class HumanPlayer implements PlayerInterface{
    private Scanner scan;
    private int player_id;
    private int lives_left;
    private Board board;

    public HumanPlayer(int player_id){
        this.player_id = player_id;
        lives_left = 17;
        scan = new Scanner(System.in);
        board = new Board();
    }

    public int getId(){return player_id;}
    public Board getBoard(){return board;}


    @Override
    public void placeShips(){
        System.out.print("\n==== Placing ships for player "+player_id+" ====");
        board.placeShipsOnBoard();
    }

    @Override
    public void fireAt(PlayerInterface opponent){
        System.out.println("\nPlayer "+player_id+":");
        boolean flag = false;
        while(!flag){
            try {
                System.out.print("Enter coordinates for attack (format A...J 1...10): ");
                int y = board.indexOf(board.getLetters(),scan.next().charAt(0));
                int x = scan.nextInt() - 1; scan.nextLine();
                try {
                    Point point = new Point(x,y);
                    x = (int)point.getX();
                    y = (int)point.getY();
                    State state = ((HumanPlayer)opponent).getBoard().getImageField(x, y).objectShotAt();

                    if(state == State.DAMAGED || state == State.DESTROYED)
                        lives_left--;
                    flag = true;
                } catch (IllegalArgumentException e) {
                    System.out.print(e.getMessage());
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Format incorrect try again");
                continue;
            }
        }
    }

    @Override
    public int getLivesLeft(){return lives_left;}
}