package nucc.BattleShip.Board;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;

import nucc.BattleShip.Ships.Ship;
import nucc.BattleShip.Ships.TypeShips;
import nucc.BattleShip.Board.BoardLogic;
import nucc.BattleShip.ImageFields.GameObjectField;

public class Board extends BoardLogic{
    private static final Ship[] ships = new Ship().generateStream();
    private Scanner scan = new Scanner(System.in);;
    private boolean askPlaceOrientation(Ship ship){
        boolean flag,hor = false;
        do{
            System.out.print("\nPlace "+ship.getName()+" of length "+ship.getSize()+" horizontally(y/n)? ");
            String dir = scan.nextLine();
            switch(dir){
                case "y": hor = true; flag = false; break;
                case "n": hor = flag = false; break;
                default: flag = true; break;
            }
        }while(flag);
        return hor;
    }
    Point askValidPoint(Ship ship, boolean horizontal){
        Point from = null;
        do{
            System.out.print("\tPosition of ship "+ship.getName()+" of length "+ship.getSize()+" (format A-J 1-10): ");
            try {
                int x = indexOf(this.getLetters(),scan.next().charAt(0));
                int y = scan.nextInt() - 1; scan.nextLine();
                from = new Point(x,y);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Format incorrect try again");
                continue;
            } catch (InputMismatchException e){
                System.out.println("Format incorrect try again");
                continue;
            }
            catch (NullPointerException e){
                System.out.println("Format incorrect try again");
                continue;
            }
        }while(!validateStartPoint(from, ship.getSize(), horizontal));
        return from;
    }
    public void placeShipsOnBoard(){
        for(Ship ship: ships){
            boolean horizontal = askPlaceOrientation(ship);
            Point start = askValidPoint(ship,horizontal);
            placeShip(ship,start,horizontal);
            printBoard();
        }
    }
}