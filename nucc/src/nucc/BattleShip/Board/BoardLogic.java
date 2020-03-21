package nucc.BattleShip.Board;

import java.awt.*;
import java.util.stream.IntStream;

import nucc.BattleShip.Ships.Ship;
import nucc.BattleShip.Validators.Validator;
import nucc.BattleShip.ImageFields.GameObjectField;
import nucc.BattleShip.ImageFields.WaterObjectField;
import nucc.BattleShip.ImageFields.ShipImageField;

public class BoardLogic extends Validator{
    private static final char WATER = '~';
    private static final int BOARD_SIZE = 10;
    private static final char[] LETTERS = {'A','B','C','D','E','F','G','H','I','J'};
    
    private GameObjectField[][] board;
    
    public BoardLogic(){
        board = new GameObjectField[BOARD_SIZE][BOARD_SIZE];
        for(int r = 0; r < BOARD_SIZE; r++)
            for(int c = 0; c < BOARD_SIZE; c++)
                board[r][c] = new WaterObjectField();
    }

    public char[] getLetters(){return LETTERS;}
    
    public boolean validateInsideBoard(int x, int y){
        return super.validateInsideBoard(x, y, BOARD_SIZE);
    }
    public boolean validateStartPoint(Point from, int length, boolean horizontal){
        return super.validateStartPoint(from,length,horizontal,WATER,board);
    }
    public int indexOf(char[] arr, char val) {
        return IntStream.range(0, arr.length).filter(i -> arr[i] == val).findFirst().orElse(-1);
    }

    public void placeShip(Ship ship, Point start, boolean horizontal){
        int x_diff = horizontal? 1 : 0;
        int y_diff = !horizontal? 1: 0;
        for(int i = 0; i < ship.getSize(); i++){
            int y = (int)start.getY() + i *y_diff;
            int x = (int)start.getX() + i *x_diff;
            board[y][x] = new ShipImageField(ship);
        }

    }
    public GameObjectField getImageField(int x, int y) throws IllegalArgumentException {
        if(!validateInsideBoard(x,y))
            throw new IllegalArgumentException("Outside board\n");
        return board[y][x];
    }
    public void printBoard(){
        System.out.print("\t");
        for(char letter : LETTERS)
            System.out.print(letter + "\t");
        System.out.println();
        int i = 0;
        for(GameObjectField[] line : board){
            System.out.print(++i + "\t");
            for(GameObjectField cell : line)
                System.out.print(cell.getIcon() + "\t");
            System.out.println();
        }
    }
}